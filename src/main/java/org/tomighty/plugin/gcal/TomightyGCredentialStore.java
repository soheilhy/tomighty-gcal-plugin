/*
 * Copyright (c) 2012, Soheil Hassas Yeganeh.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.tomighty.plugin.gcal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.tomighty.config.Directories;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.CredentialStore;

/**
 * Google credential store for tomighty gcal plugin.
 *
 * @author Soheil Hassas Yeganeh <soheil@cs.toronto.edu>
 * @version 1.0
 */
public class TomightyGCredentialStore implements CredentialStore {


    private File credFile;

    public TomightyGCredentialStore(Directories dir) {
        this.credFile = new File(dir.configuration(), "tomighty.gcal");
        try {
            this.credFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean load(String userId, Credential credential) {
        try {
            ObjectInputStream reader =
                    new ObjectInputStream(new FileInputStream(credFile));
            SCredential cred = (SCredential) reader.readObject();
            credential.setAccessToken(cred.accessToken);
            credential.setExpirationTimeMilliseconds(cred.expirationinms);
            credential.setExpiresInSeconds(cred.expirationins);
            credential.setRefreshToken(cred.refreshToken);
            reader.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void store(String userId, Credential credential) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(credFile);
            ObjectOutputStream writer = new ObjectOutputStream(fos);
            SCredential scred = new SCredential(credential);
            writer.writeObject(scred);
            writer.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String userId, Credential credential) {

    }

}
