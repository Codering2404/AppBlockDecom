package com.superwall.sdk.misc;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class String_SHA256Kt {
    public static final byte[] sha256(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes(Charsets.f140510b);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            messageDigest.update(bytes);
            return messageDigest.digest();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final String sha256Hex(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArrSha256 = sha256(str);
        if (bArrSha256 != null) {
            return ArraysKt.joinToString$default(bArrSha256, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.superwall.sdk.misc.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return String_SHA256Kt.sha256Hex$lambda$0(((Byte) obj).byteValue());
                }
            }, 30, (Object) null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence sha256Hex$lambda$0(byte b3) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b3 & 255)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final Integer sha256MappedToRange(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArrSha256 = sha256(str);
        if (bArrSha256 == null) {
            return null;
        }
        List listWindowed$default = CollectionsKt.windowed$default(ArraysKt.toList(bArrSha256), 8, 8, false, 4, null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listWindowed$default, 10));
        Iterator it = listWindowed$default.iterator();
        while (it.hasNext()) {
            arrayList.add(CollectionsKt.toByteArray((List) it.next()));
        }
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            bigIntegerAdd = bigIntegerAdd.add(new BigInteger((byte[]) obj));
        }
        return Integer.valueOf(bigIntegerAdd.mod(new BigInteger("100")).intValue());
    }
}
