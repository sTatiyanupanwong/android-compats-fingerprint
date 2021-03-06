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

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.support.annotation.Nullable;

/**
 * @author Supasin Tatiyanupanwong
 */
@TargetApi(23)
@SuppressLint("MissingPermission") // It is the caller's responsibility to handle permission
class FingerprintFrameworkImplApi23 extends FingerprintFrameworkImplBase {
    @Nullable
    @Override
    public FingerprintManager getFingerprintManager(Context context) {
        try {
            return (FingerprintManager) context.getSystemService(Context.FINGERPRINT_SERVICE);
        } catch (Exception ignored) {
            return super.getFingerprintManager(context);
        }
    }

    @Override
    public boolean hasEnrolledFingerprints(Context context) {
        final FingerprintManager fingerprintManager = getFingerprintManager(context);
        if (fingerprintManager == null) {
            return false;
        }
        try {
            return fingerprintManager.hasEnrolledFingerprints();
        } catch (Exception ignored) {
            return super.hasEnrolledFingerprints(context);
        }
    }

    @Override
    public boolean isHardwareDetected(Context context) {
        final FingerprintManager fingerprintManager = getFingerprintManager(context);
        if (fingerprintManager == null) {
            return false;
        }
        try {
            return fingerprintManager.isHardwareDetected();
        } catch (Exception ignored) {
            return super.isHardwareDetected(context);
        }
    }
}
