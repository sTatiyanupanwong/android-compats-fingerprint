package com.github.statiyanupanwong.android.compats.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.annotation.Nullable;

class FingerprintFramework {
    private static final FingerprintFrameworkImpl IMPL;
    private final Context mContext;

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            IMPL = new FingerprintFrameworkApi23Impl();
        } else {
            IMPL = new FingerprintFrameworkBaseImpl();
        }
    }

    FingerprintFramework(Context context) {
        mContext = context;
    }

    public FingerprintManager getFingerprintManager() {
        return IMPL.getFingerprintManager(mContext);
    }

    public boolean isHardwareDetected() {
        return IMPL.isHardwareDetected(mContext);
    }

    public boolean hasEnrolledFingerprints() {
        return IMPL.hasEnrolledFingerprints(mContext);
    }

    public boolean isFingerprintPermissionGranted() {
        return IMPL.isFingerprintPermissionGranted(mContext);
    }

    interface FingerprintFrameworkImpl {
        @Nullable
        FingerprintManager getFingerprintManager(Context context);

        boolean isHardwareDetected(Context context);

        boolean hasEnrolledFingerprints(Context context);

        boolean isFingerprintPermissionGranted(Context context);
    }
}