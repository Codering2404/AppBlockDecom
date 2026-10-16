package com.google.crypto.tink.internal;

import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.tinkkey.KeyHandle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class KeyStatusTypeProtoConverter {

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.KeyStatusTypeProtoConverter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f86235b;

        static {
            int[] iArr = new int[KeyHandle.KeyStatusType.values().length];
            f86235b = iArr;
            try {
                iArr[KeyHandle.KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86235b[KeyHandle.KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86235b[KeyHandle.KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[KeyStatusType.values().length];
            f86234a = iArr2;
            try {
                iArr2[KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f86234a[KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f86234a[KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
