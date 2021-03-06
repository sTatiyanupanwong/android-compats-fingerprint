/*
 * Copyright (C) 2017-2018 Supasin Tatiyanupanwong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.tatiyanupanwong.supasin.android.imprint;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/**
 * @author Supasin Tatiyanupanwong
 */
final class EncryptionCipherTask extends FingerprintCipherTask {
    private EncryptionCipherTask(String alias, Callback callback) {
        super(alias, callback);
    }

    public static EncryptionCipherTask with(String alias, Callback callback) {
        return new EncryptionCipherTask(alias, callback);
    }

    @Override
    void initCipher(Cipher cipher, SecretKey secretKey) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    }
}
