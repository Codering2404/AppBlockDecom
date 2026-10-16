package com.google.crypto.tink.prf;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HkdfPrfKeyFormat;
import com.google.crypto.tink.proto.HkdfPrfParams;
import com.google.crypto.tink.subtle.prf.StreamingPrf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class HkdfPrfKeyManager extends KeyTypeManager<com.google.crypto.tink.proto.HkdfPrfKey> {

    /* JADX INFO: renamed from: com.google.crypto.tink.prf.HkdfPrfKeyManager$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86396a;

        static {
            int[] iArr = new int[HashType.values().length];
            f86396a = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86396a[HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86396a[HashType.SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86396a[HashType.SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    HkdfPrfKeyManager() {
        super(com.google.crypto.tink.proto.HkdfPrfKey.class, new PrimitiveFactory<StreamingPrf, com.google.crypto.tink.proto.HkdfPrfKey>(StreamingPrf.class) { // from class: com.google.crypto.tink.prf.HkdfPrfKeyManager.1
        }, new PrimitiveFactory<Prf, com.google.crypto.tink.proto.HkdfPrfKey>(Prf.class) { // from class: com.google.crypto.tink.prf.HkdfPrfKeyManager.2
        });
    }

    public static void f(boolean z2) {
        Registry.e(new HkdfPrfKeyManager(), z2);
        HkdfPrfProtoSerialization.a();
    }

    public static String g() {
        return new HkdfPrfKeyManager().c();
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.HkdfPrfKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<HkdfPrfKeyFormat, com.google.crypto.tink.proto.HkdfPrfKey>(HkdfPrfKeyFormat.class) { // from class: com.google.crypto.tink.prf.HkdfPrfKeyManager.3
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                map.put("HKDF_SHA256", new KeyTypeManager.KeyFactory.KeyFormat((HkdfPrfKeyFormat) HkdfPrfKeyFormat.T().J(32).K(HkdfPrfParams.S().J(HashType.SHA256)).build(), KeyTemplate.OutputPrefixType.RAW));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
