package kotlin.collections.unsigned;

import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.MapsKt;
import kotlin.collections.UArraySortingKt;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class UArraysKt___UArraysKt extends UArraysKt___UArraysJvmKt {
    /* JADX INFO: renamed from: all-JOV_ifY, reason: not valid java name */
    private static final boolean m1544allJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$all$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (!((Boolean) predicate.invoke(UByte.a(UByteArray.l(bArr, i3)))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: all-MShoTSo, reason: not valid java name */
    private static final boolean m1545allMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$all$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (!((Boolean) predicate.invoke(ULong.a(ULongArray.l(jArr, i3)))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: all-jgv0xPQ, reason: not valid java name */
    private static final boolean m1546alljgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$all$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (!((Boolean) predicate.invoke(UInt.a(UIntArray.l(iArr, i3)))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: all-xTcfx_M, reason: not valid java name */
    private static final boolean m1547allxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$all$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (!((Boolean) predicate.invoke(UShort.a(UShortArray.l(sArr, i3)))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: any--ajY-9A, reason: not valid java name */
    private static final boolean m1548anyajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$any$0");
        return ArraysKt.any(iArr);
    }

    /* JADX INFO: renamed from: any-GBYM_sE, reason: not valid java name */
    private static final boolean m1549anyGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$any$0");
        return ArraysKt.any(bArr);
    }

    /* JADX INFO: renamed from: any-JOV_ifY, reason: not valid java name */
    private static final boolean m1550anyJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$any$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (((Boolean) predicate.invoke(UByte.a(UByteArray.l(bArr, i3)))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: any-MShoTSo, reason: not valid java name */
    private static final boolean m1551anyMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$any$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (((Boolean) predicate.invoke(ULong.a(ULongArray.l(jArr, i3)))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: any-QwZRm1k, reason: not valid java name */
    private static final boolean m1552anyQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$any$0");
        return ArraysKt.any(jArr);
    }

    /* JADX INFO: renamed from: any-jgv0xPQ, reason: not valid java name */
    private static final boolean m1553anyjgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$any$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (((Boolean) predicate.invoke(UInt.a(UIntArray.l(iArr, i3)))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: any-rL5Bavg, reason: not valid java name */
    private static final boolean m1554anyrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$any$0");
        return ArraysKt.any(sArr);
    }

    /* JADX INFO: renamed from: asByteArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m1556asByteArrayGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$asByteArray$0");
        return bArr;
    }

    /* JADX INFO: renamed from: asIntArray--ajY-9A, reason: not valid java name */
    private static final int[] m1557asIntArrayajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$asIntArray$0");
        return iArr;
    }

    /* JADX INFO: renamed from: asLongArray-QwZRm1k, reason: not valid java name */
    private static final long[] m1558asLongArrayQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$asLongArray$0");
        return jArr;
    }

    /* JADX INFO: renamed from: asShortArray-rL5Bavg, reason: not valid java name */
    private static final short[] m1559asShortArrayrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$asShortArray$0");
        return sArr;
    }

    private static final byte[] asUByteArray(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return UByteArray.d(bArr);
    }

    private static final int[] asUIntArray(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return UIntArray.d(iArr);
    }

    private static final long[] asULongArray(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return ULongArray.d(jArr);
    }

    private static final short[] asUShortArray(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return UShortArray.d(sArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWith-JOV_ifY, reason: not valid java name */
    private static final <V> Map<UByte, V> m1560associateWithJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$associateWith$0");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(UByteArray.o(bArr)), 16));
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            linkedHashMap.put(UByte.a(bL), valueSelector.invoke(UByte.a(bL)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWith-MShoTSo, reason: not valid java name */
    private static final <V> Map<ULong, V> m1561associateWithMShoTSo(long[] jArr, Function1<? super ULong, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$associateWith$0");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(ULongArray.o(jArr)), 16));
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            linkedHashMap.put(ULong.a(jL), valueSelector.invoke(ULong.a(jL)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWith-jgv0xPQ, reason: not valid java name */
    private static final <V> Map<UInt, V> m1562associateWithjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$associateWith$0");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(UIntArray.o(iArr)), 16));
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            linkedHashMap.put(UInt.a(iL), valueSelector.invoke(UInt.a(iL)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWith-xTcfx_M, reason: not valid java name */
    private static final <V> Map<UShort, V> m1563associateWithxTcfx_M(short[] sArr, Function1<? super UShort, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$associateWith$0");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(UShortArray.o(sArr)), 16));
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            linkedHashMap.put(UShort.a(sL), valueSelector.invoke(UShort.a(sL)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWithTo-4D70W2E, reason: not valid java name */
    private static final <V, M extends Map<? super UInt, ? super V>> M m1564associateWithTo4D70W2E(int[] iArr, M destination, Function1<? super UInt, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$associateWithTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            destination.put(UInt.a(iL), valueSelector.invoke(UInt.a(iL)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWithTo-H21X9dk, reason: not valid java name */
    private static final <V, M extends Map<? super UByte, ? super V>> M m1565associateWithToH21X9dk(byte[] bArr, M destination, Function1<? super UByte, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$associateWithTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            destination.put(UByte.a(bL), valueSelector.invoke(UByte.a(bL)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWithTo-X6OPwNk, reason: not valid java name */
    private static final <V, M extends Map<? super ULong, ? super V>> M m1566associateWithToX6OPwNk(long[] jArr, M destination, Function1<? super ULong, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$associateWithTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            destination.put(ULong.a(jL), valueSelector.invoke(ULong.a(jL)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: component1--ajY-9A, reason: not valid java name */
    private static final int m1568component1ajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$component1$0");
        return UIntArray.l(iArr, 0);
    }

    /* JADX INFO: renamed from: component1-GBYM_sE, reason: not valid java name */
    private static final byte m1569component1GBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$component1$0");
        return UByteArray.l(bArr, 0);
    }

    /* JADX INFO: renamed from: component1-QwZRm1k, reason: not valid java name */
    private static final long m1570component1QwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$component1$0");
        return ULongArray.l(jArr, 0);
    }

    /* JADX INFO: renamed from: component1-rL5Bavg, reason: not valid java name */
    private static final short m1571component1rL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$component1$0");
        return UShortArray.l(sArr, 0);
    }

    /* JADX INFO: renamed from: component2--ajY-9A, reason: not valid java name */
    private static final int m1572component2ajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$component2$0");
        return UIntArray.l(iArr, 1);
    }

    /* JADX INFO: renamed from: component2-GBYM_sE, reason: not valid java name */
    private static final byte m1573component2GBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$component2$0");
        return UByteArray.l(bArr, 1);
    }

    /* JADX INFO: renamed from: component2-QwZRm1k, reason: not valid java name */
    private static final long m1574component2QwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$component2$0");
        return ULongArray.l(jArr, 1);
    }

    /* JADX INFO: renamed from: component2-rL5Bavg, reason: not valid java name */
    private static final short m1575component2rL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$component2$0");
        return UShortArray.l(sArr, 1);
    }

    /* JADX INFO: renamed from: component3--ajY-9A, reason: not valid java name */
    private static final int m1576component3ajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$component3$0");
        return UIntArray.l(iArr, 2);
    }

    /* JADX INFO: renamed from: component3-GBYM_sE, reason: not valid java name */
    private static final byte m1577component3GBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$component3$0");
        return UByteArray.l(bArr, 2);
    }

    /* JADX INFO: renamed from: component3-QwZRm1k, reason: not valid java name */
    private static final long m1578component3QwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$component3$0");
        return ULongArray.l(jArr, 2);
    }

    /* JADX INFO: renamed from: component3-rL5Bavg, reason: not valid java name */
    private static final short m1579component3rL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$component3$0");
        return UShortArray.l(sArr, 2);
    }

    /* JADX INFO: renamed from: component4--ajY-9A, reason: not valid java name */
    private static final int m1580component4ajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$component4$0");
        return UIntArray.l(iArr, 3);
    }

    /* JADX INFO: renamed from: component4-GBYM_sE, reason: not valid java name */
    private static final byte m1581component4GBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$component4$0");
        return UByteArray.l(bArr, 3);
    }

    /* JADX INFO: renamed from: component4-QwZRm1k, reason: not valid java name */
    private static final long m1582component4QwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$component4$0");
        return ULongArray.l(jArr, 3);
    }

    /* JADX INFO: renamed from: component4-rL5Bavg, reason: not valid java name */
    private static final short m1583component4rL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$component4$0");
        return UShortArray.l(sArr, 3);
    }

    /* JADX INFO: renamed from: component5--ajY-9A, reason: not valid java name */
    private static final int m1584component5ajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$component5$0");
        return UIntArray.l(iArr, 4);
    }

    /* JADX INFO: renamed from: component5-GBYM_sE, reason: not valid java name */
    private static final byte m1585component5GBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$component5$0");
        return UByteArray.l(bArr, 4);
    }

    /* JADX INFO: renamed from: component5-QwZRm1k, reason: not valid java name */
    private static final long m1586component5QwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$component5$0");
        return ULongArray.l(jArr, 4);
    }

    /* JADX INFO: renamed from: component5-rL5Bavg, reason: not valid java name */
    private static final short m1587component5rL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$component5$0");
        return UShortArray.l(sArr, 4);
    }

    /* JADX INFO: renamed from: contentEquals-FGO6Aew, reason: not valid java name */
    public static boolean m1588contentEqualsFGO6Aew(short[] sArr, short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    /* JADX INFO: renamed from: contentEquals-KJPZfPQ, reason: not valid java name */
    public static boolean m1589contentEqualsKJPZfPQ(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    /* JADX INFO: renamed from: contentEquals-kV0jMPg, reason: not valid java name */
    public static boolean m1590contentEqualskV0jMPg(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    /* JADX INFO: renamed from: contentEquals-lec5QzE, reason: not valid java name */
    public static boolean m1591contentEqualslec5QzE(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    /* JADX INFO: renamed from: contentHashCode-2csIQuQ, reason: not valid java name */
    public static final int m1592contentHashCode2csIQuQ(byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    /* JADX INFO: renamed from: contentHashCode-XUkPCBk, reason: not valid java name */
    public static final int m1593contentHashCodeXUkPCBk(int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    /* JADX INFO: renamed from: contentHashCode-d-6D3K8, reason: not valid java name */
    public static final int m1594contentHashCoded6D3K8(short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    /* JADX INFO: renamed from: contentHashCode-uLth9ew, reason: not valid java name */
    public static final int m1595contentHashCodeuLth9ew(long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    /* JADX INFO: renamed from: contentToString-2csIQuQ, reason: not valid java name */
    public static String m1596contentToString2csIQuQ(byte[] bArr) {
        String strJoinToString$default;
        return (bArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(UByteArray.a(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    /* JADX INFO: renamed from: contentToString-XUkPCBk, reason: not valid java name */
    public static String m1597contentToStringXUkPCBk(int[] iArr) {
        String strJoinToString$default;
        return (iArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(UIntArray.a(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    /* JADX INFO: renamed from: contentToString-d-6D3K8, reason: not valid java name */
    public static String m1598contentToStringd6D3K8(short[] sArr) {
        String strJoinToString$default;
        return (sArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(UShortArray.a(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    /* JADX INFO: renamed from: contentToString-uLth9ew, reason: not valid java name */
    public static String m1599contentToStringuLth9ew(long[] jArr) {
        String strJoinToString$default;
        return (jArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(ULongArray.a(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    /* JADX INFO: renamed from: copyInto--B0-L2c, reason: not valid java name */
    private static final long[] m1600copyIntoB0L2c(long[] jArr, long[] jArr2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$copyInto$0");
        Intrinsics.checkNotNullParameter(jArr2, "$v$c$kotlin-ULongArray$-destination$0");
        ArraysKt.copyInto(jArr, jArr2, i3, i4, i5);
        return jArr2;
    }

    /* JADX INFO: renamed from: copyInto--B0-L2c$default, reason: not valid java name */
    static /* synthetic */ long[] m1601copyIntoB0L2c$default(long[] jArr, long[] jArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = ULongArray.o(jArr);
        }
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$copyInto$0");
        Intrinsics.checkNotNullParameter(jArr2, "$v$c$kotlin-ULongArray$-destination$0");
        ArraysKt.copyInto(jArr, jArr2, i3, i4, i5);
        return jArr2;
    }

    /* JADX INFO: renamed from: copyInto-9-ak10g, reason: not valid java name */
    private static final short[] m1602copyInto9ak10g(short[] sArr, short[] sArr2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$copyInto$0");
        Intrinsics.checkNotNullParameter(sArr2, "$v$c$kotlin-UShortArray$-destination$0");
        ArraysKt.copyInto(sArr, sArr2, i3, i4, i5);
        return sArr2;
    }

    /* JADX INFO: renamed from: copyInto-9-ak10g$default, reason: not valid java name */
    static /* synthetic */ short[] m1603copyInto9ak10g$default(short[] sArr, short[] sArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = UShortArray.o(sArr);
        }
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$copyInto$0");
        Intrinsics.checkNotNullParameter(sArr2, "$v$c$kotlin-UShortArray$-destination$0");
        ArraysKt.copyInto(sArr, sArr2, i3, i4, i5);
        return sArr2;
    }

    /* JADX INFO: renamed from: copyInto-FUQE5sA, reason: not valid java name */
    private static final byte[] m1604copyIntoFUQE5sA(byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$copyInto$0");
        Intrinsics.checkNotNullParameter(bArr2, "$v$c$kotlin-UByteArray$-destination$0");
        ArraysKt.copyInto(bArr, bArr2, i3, i4, i5);
        return bArr2;
    }

    /* JADX INFO: renamed from: copyInto-FUQE5sA$default, reason: not valid java name */
    static /* synthetic */ byte[] m1605copyIntoFUQE5sA$default(byte[] bArr, byte[] bArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = UByteArray.o(bArr);
        }
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$copyInto$0");
        Intrinsics.checkNotNullParameter(bArr2, "$v$c$kotlin-UByteArray$-destination$0");
        ArraysKt.copyInto(bArr, bArr2, i3, i4, i5);
        return bArr2;
    }

    /* JADX INFO: renamed from: copyInto-sIZ3KeM, reason: not valid java name */
    private static final int[] m1606copyIntosIZ3KeM(int[] iArr, int[] iArr2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$copyInto$0");
        Intrinsics.checkNotNullParameter(iArr2, "$v$c$kotlin-UIntArray$-destination$0");
        ArraysKt.copyInto(iArr, iArr2, i3, i4, i5);
        return iArr2;
    }

    /* JADX INFO: renamed from: copyInto-sIZ3KeM$default, reason: not valid java name */
    static /* synthetic */ int[] m1607copyIntosIZ3KeM$default(int[] iArr, int[] iArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = UIntArray.o(iArr);
        }
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$copyInto$0");
        Intrinsics.checkNotNullParameter(iArr2, "$v$c$kotlin-UIntArray$-destination$0");
        ArraysKt.copyInto(iArr, iArr2, i3, i4, i5);
        return iArr2;
    }

    /* JADX INFO: renamed from: copyOf--ajY-9A, reason: not valid java name */
    private static final int[] m1608copyOfajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$copyOf$0");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return UIntArray.d(iArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-CVVdw08, reason: not valid java name */
    private static final short[] m1609copyOfCVVdw08(short[] sArr, int i3, Function1<? super Integer, UShort> init) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$copyOf$0");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, i3);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrD = UShortArray.d(sArrCopyOf);
        for (int iO = UShortArray.o(sArr); iO < i3; iO++) {
            UShortArray.t(sArrD, iO, ((UShort) init.invoke(Integer.valueOf(iO))).f());
        }
        return sArrD;
    }

    /* JADX INFO: renamed from: copyOf-GBYM_sE, reason: not valid java name */
    private static final byte[] m1610copyOfGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$copyOf$0");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return UByteArray.d(bArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-PpDY95g, reason: not valid java name */
    private static final byte[] m1611copyOfPpDY95g(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$copyOf$0");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return UByteArray.d(bArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-QwZRm1k, reason: not valid java name */
    private static final long[] m1612copyOfQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$copyOf$0");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return ULongArray.d(jArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-QxvSvLU, reason: not valid java name */
    private static final int[] m1613copyOfQxvSvLU(int[] iArr, int i3, Function1<? super Integer, UInt> init) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$copyOf$0");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, i3);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrD = UIntArray.d(iArrCopyOf);
        for (int iO = UIntArray.o(iArr); iO < i3; iO++) {
            UIntArray.t(iArrD, iO, ((UInt) init.invoke(Integer.valueOf(iO))).f());
        }
        return iArrD;
    }

    /* JADX INFO: renamed from: copyOf-Xw8i6dc, reason: not valid java name */
    private static final long[] m1614copyOfXw8i6dc(long[] jArr, int i3, Function1<? super Integer, ULong> init) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$copyOf$0");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, i3);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrD = ULongArray.d(jArrCopyOf);
        for (int iO = ULongArray.o(jArr); iO < i3; iO++) {
            ULongArray.t(jArrD, iO, ((ULong) init.invoke(Integer.valueOf(iO))).g());
        }
        return jArrD;
    }

    /* JADX INFO: renamed from: copyOf-cO-VybQ, reason: not valid java name */
    private static final byte[] m1615copyOfcOVybQ(byte[] bArr, int i3, Function1<? super Integer, UByte> init) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$copyOf$0");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrD = UByteArray.d(bArrCopyOf);
        for (int iO = UByteArray.o(bArr); iO < i3; iO++) {
            UByteArray.t(bArrD, iO, ((UByte) init.invoke(Integer.valueOf(iO))).f());
        }
        return bArrD;
    }

    /* JADX INFO: renamed from: copyOf-nggk6HY, reason: not valid java name */
    private static final short[] m1616copyOfnggk6HY(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$copyOf$0");
        short[] sArrCopyOf = Arrays.copyOf(sArr, i3);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return UShortArray.d(sArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-qFRl0hI, reason: not valid java name */
    private static final int[] m1617copyOfqFRl0hI(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$copyOf$0");
        int[] iArrCopyOf = Arrays.copyOf(iArr, i3);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return UIntArray.d(iArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-r7IrZao, reason: not valid java name */
    private static final long[] m1618copyOfr7IrZao(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$copyOf$0");
        long[] jArrCopyOf = Arrays.copyOf(jArr, i3);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return ULongArray.d(jArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-rL5Bavg, reason: not valid java name */
    private static final short[] m1619copyOfrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$copyOf$0");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return UShortArray.d(sArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOfRange--nroSd4, reason: not valid java name */
    private static final long[] m1620copyOfRangenroSd4(long[] jArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$copyOfRange$0");
        return ULongArray.d(ArraysKt.copyOfRange(jArr, i3, i4));
    }

    /* JADX INFO: renamed from: copyOfRange-4UcCI2c, reason: not valid java name */
    private static final byte[] m1621copyOfRange4UcCI2c(byte[] bArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$copyOfRange$0");
        return UByteArray.d(ArraysKt.copyOfRange(bArr, i3, i4));
    }

    /* JADX INFO: renamed from: copyOfRange-Aa5vz7o, reason: not valid java name */
    private static final short[] m1622copyOfRangeAa5vz7o(short[] sArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$copyOfRange$0");
        return UShortArray.d(ArraysKt.copyOfRange(sArr, i3, i4));
    }

    /* JADX INFO: renamed from: copyOfRange-oBK06Vg, reason: not valid java name */
    private static final int[] m1623copyOfRangeoBK06Vg(int[] iArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$copyOfRange$0");
        return UIntArray.d(ArraysKt.copyOfRange(iArr, i3, i4));
    }

    /* JADX INFO: renamed from: count-JOV_ifY, reason: not valid java name */
    private static final int m1624countJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$count$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        int i3 = 0;
        for (int i4 = 0; i4 < iO; i4++) {
            if (((Boolean) predicate.invoke(UByte.a(UByteArray.l(bArr, i4)))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: count-MShoTSo, reason: not valid java name */
    private static final int m1625countMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$count$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        int i3 = 0;
        for (int i4 = 0; i4 < iO; i4++) {
            if (((Boolean) predicate.invoke(ULong.a(ULongArray.l(jArr, i4)))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: count-jgv0xPQ, reason: not valid java name */
    private static final int m1626countjgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$count$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        int i3 = 0;
        for (int i4 = 0; i4 < iO; i4++) {
            if (((Boolean) predicate.invoke(UInt.a(UIntArray.l(iArr, i4)))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: count-xTcfx_M, reason: not valid java name */
    private static final int m1627countxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$count$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        int i3 = 0;
        for (int i4 = 0; i4 < iO; i4++) {
            if (((Boolean) predicate.invoke(UShort.a(UShortArray.l(sArr, i4)))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: drop-PpDY95g, reason: not valid java name */
    public static final List<UByte> m1628dropPpDY95g(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$drop$0");
        if (i3 >= 0) {
            return m2156takeLastPpDY95g(bArr, RangesKt.f(UByteArray.o(bArr) - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: drop-nggk6HY, reason: not valid java name */
    public static final List<UShort> m1629dropnggk6HY(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$drop$0");
        if (i3 >= 0) {
            return m2157takeLastnggk6HY(sArr, RangesKt.f(UShortArray.o(sArr) - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: drop-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m1630dropqFRl0hI(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$drop$0");
        if (i3 >= 0) {
            return m2158takeLastqFRl0hI(iArr, RangesKt.f(UIntArray.o(iArr) - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: drop-r7IrZao, reason: not valid java name */
    public static final List<ULong> m1631dropr7IrZao(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$drop$0");
        if (i3 >= 0) {
            return m2159takeLastr7IrZao(jArr, RangesKt.f(ULongArray.o(jArr) - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: dropLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m1632dropLastPpDY95g(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$dropLast$0");
        if (i3 >= 0) {
            return m2152takePpDY95g(bArr, RangesKt.f(UByteArray.o(bArr) - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: dropLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m1633dropLastnggk6HY(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$dropLast$0");
        if (i3 >= 0) {
            return m2153takenggk6HY(sArr, RangesKt.f(UShortArray.o(sArr) - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: dropLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m1634dropLastqFRl0hI(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$dropLast$0");
        if (i3 >= 0) {
            return m2154takeqFRl0hI(iArr, RangesKt.f(UIntArray.o(iArr) - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: dropLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m1635dropLastr7IrZao(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$dropLast$0");
        if (i3 >= 0) {
            return m2155taker7IrZao(jArr, RangesKt.f(ULongArray.o(jArr) - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: dropLastWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m1637dropLastWhileMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$dropLastWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt.getLastIndex(jArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(ULong.a(ULongArray.l(jArr, lastIndex)))).booleanValue()) {
                return m2155taker7IrZao(jArr, lastIndex + 1);
            }
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: dropLastWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m1638dropLastWhilejgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$dropLastWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt.getLastIndex(iArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(UInt.a(UIntArray.l(iArr, lastIndex)))).booleanValue()) {
                return m2154takeqFRl0hI(iArr, lastIndex + 1);
            }
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: dropLastWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m1639dropLastWhilexTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$dropLastWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt.getLastIndex(sArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(UShort.a(UShortArray.l(sArr, lastIndex)))).booleanValue()) {
                return m2153takenggk6HY(sArr, lastIndex + 1);
            }
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: dropWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m1640dropWhileJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$dropWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UByteArray.o(bArr);
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            if (z2) {
                arrayList.add(UByte.a(bL));
            } else if (!((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                arrayList.add(UByte.a(bL));
                z2 = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: dropWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m1641dropWhileMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$dropWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = ULongArray.o(jArr);
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            if (z2) {
                arrayList.add(ULong.a(jL));
            } else if (!((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                arrayList.add(ULong.a(jL));
                z2 = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: dropWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m1643dropWhilexTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$dropWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UShortArray.o(sArr);
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            if (z2) {
                arrayList.add(UShort.a(sL));
            } else if (!((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                arrayList.add(UShort.a(sL));
                z2 = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: elementAtOrElse-CVVdw08, reason: not valid java name */
    private static final short m1644elementAtOrElseCVVdw08(short[] sArr, int i3, Function1<? super Integer, UShort> defaultValue) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$elementAtOrElse$0");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= UShortArray.o(sArr)) ? ((UShort) defaultValue.invoke(Integer.valueOf(i3))).f() : UShortArray.l(sArr, i3);
    }

    /* JADX INFO: renamed from: elementAtOrElse-QxvSvLU, reason: not valid java name */
    private static final int m1645elementAtOrElseQxvSvLU(int[] iArr, int i3, Function1<? super Integer, UInt> defaultValue) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$elementAtOrElse$0");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= UIntArray.o(iArr)) ? ((UInt) defaultValue.invoke(Integer.valueOf(i3))).f() : UIntArray.l(iArr, i3);
    }

    /* JADX INFO: renamed from: elementAtOrElse-Xw8i6dc, reason: not valid java name */
    private static final long m1646elementAtOrElseXw8i6dc(long[] jArr, int i3, Function1<? super Integer, ULong> defaultValue) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$elementAtOrElse$0");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= ULongArray.o(jArr)) ? ((ULong) defaultValue.invoke(Integer.valueOf(i3))).g() : ULongArray.l(jArr, i3);
    }

    /* JADX INFO: renamed from: elementAtOrElse-cO-VybQ, reason: not valid java name */
    private static final byte m1647elementAtOrElsecOVybQ(byte[] bArr, int i3, Function1<? super Integer, UByte> defaultValue) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$elementAtOrElse$0");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= UByteArray.o(bArr)) ? ((UByte) defaultValue.invoke(Integer.valueOf(i3))).f() : UByteArray.l(bArr, i3);
    }

    /* JADX INFO: renamed from: elementAtOrNull-PpDY95g, reason: not valid java name */
    private static final UByte m1648elementAtOrNullPpDY95g(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$elementAtOrNull$0");
        return m1768getOrNullPpDY95g(bArr, i3);
    }

    /* JADX INFO: renamed from: elementAtOrNull-nggk6HY, reason: not valid java name */
    private static final UShort m1649elementAtOrNullnggk6HY(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$elementAtOrNull$0");
        return m1769getOrNullnggk6HY(sArr, i3);
    }

    /* JADX INFO: renamed from: elementAtOrNull-qFRl0hI, reason: not valid java name */
    private static final UInt m1650elementAtOrNullqFRl0hI(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$elementAtOrNull$0");
        return m1770getOrNullqFRl0hI(iArr, i3);
    }

    /* JADX INFO: renamed from: elementAtOrNull-r7IrZao, reason: not valid java name */
    private static final ULong m1651elementAtOrNullr7IrZao(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$elementAtOrNull$0");
        return m1771getOrNullr7IrZao(jArr, i3);
    }

    /* JADX INFO: renamed from: fill-2fe2U9s, reason: not valid java name */
    public static final void m1652fill2fe2U9s(int[] iArr, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$fill$0");
        ArraysKt.fill(iArr, i3, i4, i5);
    }

    /* JADX INFO: renamed from: fill-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ void m1653fill2fe2U9s$default(int[] iArr, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = UIntArray.o(iArr);
        }
        m1652fill2fe2U9s(iArr, i3, i4, i5);
    }

    /* JADX INFO: renamed from: fill-EtDCXyQ, reason: not valid java name */
    public static final void m1654fillEtDCXyQ(short[] sArr, short s2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$fill$0");
        ArraysKt.fill(sArr, s2, i3, i4);
    }

    /* JADX INFO: renamed from: fill-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ void m1655fillEtDCXyQ$default(short[] sArr, short s2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = UShortArray.o(sArr);
        }
        m1654fillEtDCXyQ(sArr, s2, i3, i4);
    }

    /* JADX INFO: renamed from: fill-K6DWlUc, reason: not valid java name */
    public static final void m1656fillK6DWlUc(long[] jArr, long j3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$fill$0");
        ArraysKt.fill(jArr, j3, i3, i4);
    }

    /* JADX INFO: renamed from: fill-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ void m1657fillK6DWlUc$default(long[] jArr, long j3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = ULongArray.o(jArr);
        }
        m1656fillK6DWlUc(jArr, j3, i3, i4);
    }

    /* JADX INFO: renamed from: fill-WpHrYlw, reason: not valid java name */
    public static final void m1658fillWpHrYlw(byte[] bArr, byte b3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$fill$0");
        ArraysKt.fill(bArr, b3, i3, i4);
    }

    /* JADX INFO: renamed from: fill-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ void m1659fillWpHrYlw$default(byte[] bArr, byte b3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = UByteArray.o(bArr);
        }
        m1658fillWpHrYlw(bArr, b3, i3, i4);
    }

    /* JADX INFO: renamed from: filter-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m1660filterJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$filter$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            if (((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                arrayList.add(UByte.a(bL));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filter-MShoTSo, reason: not valid java name */
    private static final List<ULong> m1661filterMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$filter$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            if (((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                arrayList.add(ULong.a(jL));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filter-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m1662filterjgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$filter$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            if (((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                arrayList.add(UInt.a(iL));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filter-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m1663filterxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$filter$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            if (((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                arrayList.add(UShort.a(sL));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-ELGow60, reason: not valid java name */
    private static final List<UByte> m1664filterIndexedELGow60(byte[] bArr, Function2<? super Integer, ? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$filterIndexed$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UByteArray.o(bArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            byte bL = UByteArray.l(bArr, i3);
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), UByte.a(bL))).booleanValue()) {
                arrayList.add(UByte.a(bL));
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-WyvcNBI, reason: not valid java name */
    private static final List<UInt> m1665filterIndexedWyvcNBI(int[] iArr, Function2<? super Integer, ? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$filterIndexed$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UIntArray.o(iArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            int iL = UIntArray.l(iArr, i3);
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), UInt.a(iL))).booleanValue()) {
                arrayList.add(UInt.a(iL));
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-s8dVfGU, reason: not valid java name */
    private static final List<ULong> m1666filterIndexeds8dVfGU(long[] jArr, Function2<? super Integer, ? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$filterIndexed$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = ULongArray.o(jArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            long jL = ULongArray.l(jArr, i3);
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), ULong.a(jL))).booleanValue()) {
                arrayList.add(ULong.a(jL));
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-xzaTVY8, reason: not valid java name */
    private static final List<UShort> m1667filterIndexedxzaTVY8(short[] sArr, Function2<? super Integer, ? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$filterIndexed$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UShortArray.o(sArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            short sL = UShortArray.l(sArr, i3);
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), UShort.a(sL))).booleanValue()) {
                arrayList.add(UShort.a(sL));
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexedTo--6EtJGI, reason: not valid java name */
    private static final <C extends Collection<? super UInt>> C m1668filterIndexedTo6EtJGI(int[] iArr, C destination, Function2<? super Integer, ? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$filterIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            int iL = UIntArray.l(iArr, i3);
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), UInt.a(iL))).booleanValue()) {
                destination.add(UInt.a(iL));
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <C extends Collection<? super UShort>> C m1669filterIndexedToQqktQ3k(short[] sArr, C destination, Function2<? super Integer, ? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$filterIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            short sL = UShortArray.l(sArr, i3);
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), UShort.a(sL))).booleanValue()) {
                destination.add(UShort.a(sL));
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <C extends Collection<? super UByte>> C m1670filterIndexedToeNpIKz8(byte[] bArr, C destination, Function2<? super Integer, ? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$filterIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            byte bL = UByteArray.l(bArr, i3);
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), UByte.a(bL))).booleanValue()) {
                destination.add(UByte.a(bL));
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <C extends Collection<? super ULong>> C m1671filterIndexedTope2Q0Dw(long[] jArr, C destination, Function2<? super Integer, ? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$filterIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            long jL = ULongArray.l(jArr, i3);
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), ULong.a(jL))).booleanValue()) {
                destination.add(ULong.a(jL));
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNot-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m1672filterNotJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$filterNot$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            if (!((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                arrayList.add(UByte.a(bL));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNot-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m1674filterNotjgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$filterNot$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            if (!((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                arrayList.add(UInt.a(iL));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNot-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m1675filterNotxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$filterNot$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            if (!((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                arrayList.add(UShort.a(sL));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNotTo-HqK1JgA, reason: not valid java name */
    private static final <C extends Collection<? super ULong>> C m1676filterNotToHqK1JgA(long[] jArr, C destination, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$filterNotTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            if (!((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                destination.add(ULong.a(jL));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNotTo-oEOeDjA, reason: not valid java name */
    private static final <C extends Collection<? super UShort>> C m1677filterNotTooEOeDjA(short[] sArr, C destination, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$filterNotTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            if (!((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                destination.add(UShort.a(sL));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNotTo-wU5IKMo, reason: not valid java name */
    private static final <C extends Collection<? super UInt>> C m1678filterNotTowU5IKMo(int[] iArr, C destination, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$filterNotTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            if (!((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                destination.add(UInt.a(iL));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNotTo-wzUQCXU, reason: not valid java name */
    private static final <C extends Collection<? super UByte>> C m1679filterNotTowzUQCXU(byte[] bArr, C destination, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$filterNotTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            if (!((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                destination.add(UByte.a(bL));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-HqK1JgA, reason: not valid java name */
    private static final <C extends Collection<? super ULong>> C m1680filterToHqK1JgA(long[] jArr, C destination, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$filterTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            if (((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                destination.add(ULong.a(jL));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-oEOeDjA, reason: not valid java name */
    private static final <C extends Collection<? super UShort>> C m1681filterTooEOeDjA(short[] sArr, C destination, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$filterTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            if (((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                destination.add(UShort.a(sL));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-wU5IKMo, reason: not valid java name */
    private static final <C extends Collection<? super UInt>> C m1682filterTowU5IKMo(int[] iArr, C destination, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$filterTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            if (((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                destination.add(UInt.a(iL));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-wzUQCXU, reason: not valid java name */
    private static final <C extends Collection<? super UByte>> C m1683filterTowzUQCXU(byte[] bArr, C destination, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$filterTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            if (((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                destination.add(UByte.a(bL));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: find-JOV_ifY, reason: not valid java name */
    private static final UByte m1684findJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$find$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            if (((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                return UByte.a(bL);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: find-MShoTSo, reason: not valid java name */
    private static final ULong m1685findMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$find$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            if (((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                return ULong.a(jL);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: find-jgv0xPQ, reason: not valid java name */
    private static final UInt m1686findjgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$find$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            if (((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                return UInt.a(iL);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: find-xTcfx_M, reason: not valid java name */
    private static final UShort m1687findxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$find$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            if (((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                return UShort.a(sL);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: findLast-JOV_ifY, reason: not valid java name */
    private static final UByte m1688findLastJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$findLast$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i3 = iO - 1;
            byte bL = UByteArray.l(bArr, iO);
            if (((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                return UByte.a(bL);
            }
            if (i3 < 0) {
                return null;
            }
            iO = i3;
        }
    }

    /* JADX INFO: renamed from: findLast-MShoTSo, reason: not valid java name */
    private static final ULong m1689findLastMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$findLast$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i3 = iO - 1;
            long jL = ULongArray.l(jArr, iO);
            if (((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                return ULong.a(jL);
            }
            if (i3 < 0) {
                return null;
            }
            iO = i3;
        }
    }

    /* JADX INFO: renamed from: findLast-jgv0xPQ, reason: not valid java name */
    private static final UInt m1690findLastjgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$findLast$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i3 = iO - 1;
            int iL = UIntArray.l(iArr, iO);
            if (((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                return UInt.a(iL);
            }
            if (i3 < 0) {
                return null;
            }
            iO = i3;
        }
    }

    /* JADX INFO: renamed from: findLast-xTcfx_M, reason: not valid java name */
    private static final UShort m1691findLastxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$findLast$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i3 = iO - 1;
            short sL = UShortArray.l(sArr, iO);
            if (((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                return UShort.a(sL);
            }
            if (i3 < 0) {
                return null;
            }
            iO = i3;
        }
    }

    /* JADX INFO: renamed from: first--ajY-9A, reason: not valid java name */
    private static final int m1692firstajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$first$0");
        return UInt.b(ArraysKt.first(iArr));
    }

    /* JADX INFO: renamed from: first-GBYM_sE, reason: not valid java name */
    private static final byte m1693firstGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$first$0");
        return UByte.b(ArraysKt.first(bArr));
    }

    /* JADX INFO: renamed from: first-JOV_ifY, reason: not valid java name */
    private static final byte m1694firstJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$first$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            if (((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                return bL;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: first-MShoTSo, reason: not valid java name */
    private static final long m1695firstMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$first$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            if (((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                return jL;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: first-QwZRm1k, reason: not valid java name */
    private static final long m1696firstQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$first$0");
        return ULong.b(ArraysKt.first(jArr));
    }

    /* JADX INFO: renamed from: first-jgv0xPQ, reason: not valid java name */
    private static final int m1697firstjgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$first$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            if (((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                return iL;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: first-rL5Bavg, reason: not valid java name */
    private static final short m1698firstrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$first$0");
        return UShort.b(ArraysKt.first(sArr));
    }

    /* JADX INFO: renamed from: first-xTcfx_M, reason: not valid java name */
    private static final short m1699firstxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$first$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            if (((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                return sL;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: firstOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m1700firstOrNullajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$firstOrNull$0");
        if (UIntArray.q(iArr)) {
            return null;
        }
        return UInt.a(UIntArray.l(iArr, 0));
    }

    /* JADX INFO: renamed from: firstOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m1701firstOrNullGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$firstOrNull$0");
        if (UByteArray.q(bArr)) {
            return null;
        }
        return UByte.a(UByteArray.l(bArr, 0));
    }

    /* JADX INFO: renamed from: firstOrNull-JOV_ifY, reason: not valid java name */
    private static final UByte m1702firstOrNullJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$firstOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            if (((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                return UByte.a(bL);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: firstOrNull-MShoTSo, reason: not valid java name */
    private static final ULong m1703firstOrNullMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$firstOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            if (((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                return ULong.a(jL);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: firstOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m1704firstOrNullQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$firstOrNull$0");
        if (ULongArray.q(jArr)) {
            return null;
        }
        return ULong.a(ULongArray.l(jArr, 0));
    }

    /* JADX INFO: renamed from: firstOrNull-jgv0xPQ, reason: not valid java name */
    private static final UInt m1705firstOrNulljgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$firstOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            if (((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                return UInt.a(iL);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: firstOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m1706firstOrNullrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$firstOrNull$0");
        if (UShortArray.q(sArr)) {
            return null;
        }
        return UShort.a(UShortArray.l(sArr, 0));
    }

    /* JADX INFO: renamed from: firstOrNull-xTcfx_M, reason: not valid java name */
    private static final UShort m1707firstOrNullxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$firstOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            if (((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                return UShort.a(sL);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: flatMap-JOV_ifY, reason: not valid java name */
    private static final <R> List<R> m1708flatMapJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$flatMap$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            CollectionsKt.addAll(arrayList, (Iterable) transform.invoke(UByte.a(UByteArray.l(bArr, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMap-MShoTSo, reason: not valid java name */
    private static final <R> List<R> m1709flatMapMShoTSo(long[] jArr, Function1<? super ULong, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$flatMap$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            CollectionsKt.addAll(arrayList, (Iterable) transform.invoke(ULong.a(ULongArray.l(jArr, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMap-jgv0xPQ, reason: not valid java name */
    private static final <R> List<R> m1710flatMapjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$flatMap$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            CollectionsKt.addAll(arrayList, (Iterable) transform.invoke(UInt.a(UIntArray.l(iArr, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMap-xTcfx_M, reason: not valid java name */
    private static final <R> List<R> m1711flatMapxTcfx_M(short[] sArr, Function1<? super UShort, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$flatMap$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            CollectionsKt.addAll(arrayList, (Iterable) transform.invoke(UShort.a(UShortArray.l(sArr, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-ELGow60, reason: not valid java name */
    private static final <R> List<R> m1712flatMapIndexedELGow60(byte[] bArr, Function2<? super Integer, ? super UByte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$flatMapIndexed$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = UByteArray.o(bArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            CollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), UByte.a(UByteArray.l(bArr, i3))));
            i3++;
            i4++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-WyvcNBI, reason: not valid java name */
    private static final <R> List<R> m1713flatMapIndexedWyvcNBI(int[] iArr, Function2<? super Integer, ? super UInt, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$flatMapIndexed$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = UIntArray.o(iArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            CollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), UInt.a(UIntArray.l(iArr, i3))));
            i3++;
            i4++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-s8dVfGU, reason: not valid java name */
    private static final <R> List<R> m1714flatMapIndexeds8dVfGU(long[] jArr, Function2<? super Integer, ? super ULong, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$flatMapIndexed$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = ULongArray.o(jArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            CollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), ULong.a(ULongArray.l(jArr, i3))));
            i3++;
            i4++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-xzaTVY8, reason: not valid java name */
    private static final <R> List<R> m1715flatMapIndexedxzaTVY8(short[] sArr, Function2<? super Integer, ? super UShort, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$flatMapIndexed$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = UShortArray.o(sArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            CollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), UShort.a(UShortArray.l(sArr, i3))));
            i3++;
            i4++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo--6EtJGI, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1716flatMapIndexedTo6EtJGI(int[] iArr, C destination, Function2<? super Integer, ? super UInt, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$flatMapIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UIntArray.o(iArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            CollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), UInt.a(UIntArray.l(iArr, i3))));
            i3++;
            i4++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1717flatMapIndexedToQqktQ3k(short[] sArr, C destination, Function2<? super Integer, ? super UShort, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$flatMapIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UShortArray.o(sArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            CollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), UShort.a(UShortArray.l(sArr, i3))));
            i3++;
            i4++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1718flatMapIndexedToeNpIKz8(byte[] bArr, C destination, Function2<? super Integer, ? super UByte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$flatMapIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UByteArray.o(bArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            CollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), UByte.a(UByteArray.l(bArr, i3))));
            i3++;
            i4++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1719flatMapIndexedTope2Q0Dw(long[] jArr, C destination, Function2<? super Integer, ? super ULong, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$flatMapIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = ULongArray.o(jArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            CollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), ULong.a(ULongArray.l(jArr, i3))));
            i3++;
            i4++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-HqK1JgA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1720flatMapToHqK1JgA(long[] jArr, C destination, Function1<? super ULong, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$flatMapTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            CollectionsKt.addAll(destination, (Iterable) transform.invoke(ULong.a(ULongArray.l(jArr, i3))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-oEOeDjA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1721flatMapTooEOeDjA(short[] sArr, C destination, Function1<? super UShort, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$flatMapTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            CollectionsKt.addAll(destination, (Iterable) transform.invoke(UShort.a(UShortArray.l(sArr, i3))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-wU5IKMo, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1722flatMapTowU5IKMo(int[] iArr, C destination, Function1<? super UInt, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$flatMapTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            CollectionsKt.addAll(destination, (Iterable) transform.invoke(UInt.a(UIntArray.l(iArr, i3))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-wzUQCXU, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1723flatMapTowzUQCXU(byte[] bArr, C destination, Function1<? super UByte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$flatMapTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            CollectionsKt.addAll(destination, (Iterable) transform.invoke(UByte.a(UByteArray.l(bArr, i3))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: fold-A8wKCXQ, reason: not valid java name */
    private static final <R> R m1724foldA8wKCXQ(long[] jArr, R r2, Function2<? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$fold$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, ULong.a(ULongArray.l(jArr, i3)));
        }
        return r2;
    }

    /* JADX INFO: renamed from: fold-yXmHNn8, reason: not valid java name */
    private static final <R> R m1725foldyXmHNn8(byte[] bArr, R r2, Function2<? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$fold$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, UByte.a(UByteArray.l(bArr, i3)));
        }
        return r2;
    }

    /* JADX INFO: renamed from: fold-zi1B2BA, reason: not valid java name */
    private static final <R> R m1726foldzi1B2BA(int[] iArr, R r2, Function2<? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$fold$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, UInt.a(UIntArray.l(iArr, i3)));
        }
        return r2;
    }

    /* JADX INFO: renamed from: fold-zww5nb8, reason: not valid java name */
    private static final <R> R m1727foldzww5nb8(short[] sArr, R r2, Function2<? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$fold$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, UShort.a(UShortArray.l(sArr, i3)));
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> R m1728foldIndexed3iWJZGE(byte[] bArr, R r2, Function3<? super Integer, ? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$foldIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iO = UByteArray.o(bArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, UByte.a(UByteArray.l(bArr, i3)));
            i3++;
            i4++;
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldIndexed-bzxtMww, reason: not valid java name */
    private static final <R> R m1729foldIndexedbzxtMww(short[] sArr, R r2, Function3<? super Integer, ? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$foldIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iO = UShortArray.o(sArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, UShort.a(UShortArray.l(sArr, i3)));
            i3++;
            i4++;
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> R m1730foldIndexedmwnnOCs(long[] jArr, R r2, Function3<? super Integer, ? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$foldIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iO = ULongArray.o(jArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, ULong.a(ULongArray.l(jArr, i3)));
            i3++;
            i4++;
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> R m1731foldIndexedyVwIW0Q(int[] iArr, R r2, Function3<? super Integer, ? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$foldIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iO = UIntArray.o(iArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, UInt.a(UIntArray.l(iArr, i3)));
            i3++;
            i4++;
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldRight-A8wKCXQ, reason: not valid java name */
    private static final <R> R m1732foldRightA8wKCXQ(long[] jArr, R r2, Function2<? super ULong, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$foldRight$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt.getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(ULong.a(ULongArray.l(jArr, lastIndex)), r2);
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldRight-yXmHNn8, reason: not valid java name */
    private static final <R> R m1733foldRightyXmHNn8(byte[] bArr, R r2, Function2<? super UByte, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$foldRight$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt.getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(UByte.a(UByteArray.l(bArr, lastIndex)), r2);
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldRight-zi1B2BA, reason: not valid java name */
    private static final <R> R m1734foldRightzi1B2BA(int[] iArr, R r2, Function2<? super UInt, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$foldRight$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt.getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(UInt.a(UIntArray.l(iArr, lastIndex)), r2);
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldRight-zww5nb8, reason: not valid java name */
    private static final <R> R m1735foldRightzww5nb8(short[] sArr, R r2, Function2<? super UShort, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$foldRight$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt.getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(UShort.a(UShortArray.l(sArr, lastIndex)), r2);
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldRightIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> R m1736foldRightIndexed3iWJZGE(byte[] bArr, R r2, Function3<? super Integer, ? super UByte, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$foldRightIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt.getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), UByte.a(UByteArray.l(bArr, lastIndex)), r2);
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldRightIndexed-bzxtMww, reason: not valid java name */
    private static final <R> R m1737foldRightIndexedbzxtMww(short[] sArr, R r2, Function3<? super Integer, ? super UShort, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$foldRightIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt.getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), UShort.a(UShortArray.l(sArr, lastIndex)), r2);
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldRightIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> R m1738foldRightIndexedmwnnOCs(long[] jArr, R r2, Function3<? super Integer, ? super ULong, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$foldRightIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt.getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), ULong.a(ULongArray.l(jArr, lastIndex)), r2);
        }
        return r2;
    }

    /* JADX INFO: renamed from: foldRightIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> R m1739foldRightIndexedyVwIW0Q(int[] iArr, R r2, Function3<? super Integer, ? super UInt, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$foldRightIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = ArraysKt.getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), UInt.a(UIntArray.l(iArr, lastIndex)), r2);
        }
        return r2;
    }

    /* JADX INFO: renamed from: forEach-JOV_ifY, reason: not valid java name */
    private static final void m1740forEachJOV_ifY(byte[] bArr, Function1<? super UByte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$forEach$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            action.invoke(UByte.a(UByteArray.l(bArr, i3)));
        }
    }

    /* JADX INFO: renamed from: forEach-MShoTSo, reason: not valid java name */
    private static final void m1741forEachMShoTSo(long[] jArr, Function1<? super ULong, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$forEach$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            action.invoke(ULong.a(ULongArray.l(jArr, i3)));
        }
    }

    /* JADX INFO: renamed from: forEach-jgv0xPQ, reason: not valid java name */
    private static final void m1742forEachjgv0xPQ(int[] iArr, Function1<? super UInt, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$forEach$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            action.invoke(UInt.a(UIntArray.l(iArr, i3)));
        }
    }

    /* JADX INFO: renamed from: forEach-xTcfx_M, reason: not valid java name */
    private static final void m1743forEachxTcfx_M(short[] sArr, Function1<? super UShort, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$forEach$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            action.invoke(UShort.a(UShortArray.l(sArr, i3)));
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-ELGow60, reason: not valid java name */
    private static final void m1744forEachIndexedELGow60(byte[] bArr, Function2<? super Integer, ? super UByte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$forEachIndexed$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UByteArray.o(bArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            action.invoke(Integer.valueOf(i4), UByte.a(UByteArray.l(bArr, i3)));
            i3++;
            i4++;
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-WyvcNBI, reason: not valid java name */
    private static final void m1745forEachIndexedWyvcNBI(int[] iArr, Function2<? super Integer, ? super UInt, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$forEachIndexed$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UIntArray.o(iArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            action.invoke(Integer.valueOf(i4), UInt.a(UIntArray.l(iArr, i3)));
            i3++;
            i4++;
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-s8dVfGU, reason: not valid java name */
    private static final void m1746forEachIndexeds8dVfGU(long[] jArr, Function2<? super Integer, ? super ULong, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$forEachIndexed$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = ULongArray.o(jArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            action.invoke(Integer.valueOf(i4), ULong.a(ULongArray.l(jArr, i3)));
            i3++;
            i4++;
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-xzaTVY8, reason: not valid java name */
    private static final void m1747forEachIndexedxzaTVY8(short[] sArr, Function2<? super Integer, ? super UShort, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$forEachIndexed$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UShortArray.o(sArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            action.invoke(Integer.valueOf(i4), UShort.a(UShortArray.l(sArr, i3)));
            i3++;
            i4++;
        }
    }

    /* JADX INFO: renamed from: getIndices--ajY-9A, reason: not valid java name */
    public static final IntRange m1748getIndicesajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$indices$0");
        return ArraysKt.getIndices(iArr);
    }

    /* JADX INFO: renamed from: getIndices--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m1749getIndicesajY9A$annotations(int[] iArr) {
    }

    /* JADX INFO: renamed from: getIndices-GBYM_sE, reason: not valid java name */
    public static final IntRange m1750getIndicesGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$indices$0");
        return ArraysKt.getIndices(bArr);
    }

    /* JADX INFO: renamed from: getIndices-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m1751getIndicesGBYM_sE$annotations(byte[] bArr) {
    }

    /* JADX INFO: renamed from: getIndices-QwZRm1k, reason: not valid java name */
    public static final IntRange m1752getIndicesQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$indices$0");
        return ArraysKt.getIndices(jArr);
    }

    /* JADX INFO: renamed from: getIndices-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m1753getIndicesQwZRm1k$annotations(long[] jArr) {
    }

    /* JADX INFO: renamed from: getIndices-rL5Bavg, reason: not valid java name */
    public static final IntRange m1754getIndicesrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$indices$0");
        return ArraysKt.getIndices(sArr);
    }

    /* JADX INFO: renamed from: getIndices-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m1755getIndicesrL5Bavg$annotations(short[] sArr) {
    }

    /* JADX INFO: renamed from: getLastIndex--ajY-9A, reason: not valid java name */
    public static final int m1756getLastIndexajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$lastIndex$0");
        return ArraysKt.getLastIndex(iArr);
    }

    /* JADX INFO: renamed from: getLastIndex--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m1757getLastIndexajY9A$annotations(int[] iArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-GBYM_sE, reason: not valid java name */
    public static final int m1758getLastIndexGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$lastIndex$0");
        return ArraysKt.getLastIndex(bArr);
    }

    /* JADX INFO: renamed from: getLastIndex-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m1759getLastIndexGBYM_sE$annotations(byte[] bArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-QwZRm1k, reason: not valid java name */
    public static final int m1760getLastIndexQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$lastIndex$0");
        return ArraysKt.getLastIndex(jArr);
    }

    /* JADX INFO: renamed from: getLastIndex-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m1761getLastIndexQwZRm1k$annotations(long[] jArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-rL5Bavg, reason: not valid java name */
    public static final int m1762getLastIndexrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$lastIndex$0");
        return ArraysKt.getLastIndex(sArr);
    }

    /* JADX INFO: renamed from: getLastIndex-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m1763getLastIndexrL5Bavg$annotations(short[] sArr) {
    }

    /* JADX INFO: renamed from: getOrElse-CVVdw08, reason: not valid java name */
    private static final short m1764getOrElseCVVdw08(short[] sArr, int i3, Function1<? super Integer, UShort> defaultValue) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$getOrElse$0");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= UShortArray.o(sArr)) ? ((UShort) defaultValue.invoke(Integer.valueOf(i3))).f() : UShortArray.l(sArr, i3);
    }

    /* JADX INFO: renamed from: getOrElse-QxvSvLU, reason: not valid java name */
    private static final int m1765getOrElseQxvSvLU(int[] iArr, int i3, Function1<? super Integer, UInt> defaultValue) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$getOrElse$0");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= UIntArray.o(iArr)) ? ((UInt) defaultValue.invoke(Integer.valueOf(i3))).f() : UIntArray.l(iArr, i3);
    }

    /* JADX INFO: renamed from: getOrElse-Xw8i6dc, reason: not valid java name */
    private static final long m1766getOrElseXw8i6dc(long[] jArr, int i3, Function1<? super Integer, ULong> defaultValue) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$getOrElse$0");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= ULongArray.o(jArr)) ? ((ULong) defaultValue.invoke(Integer.valueOf(i3))).g() : ULongArray.l(jArr, i3);
    }

    /* JADX INFO: renamed from: getOrElse-cO-VybQ, reason: not valid java name */
    private static final byte m1767getOrElsecOVybQ(byte[] bArr, int i3, Function1<? super Integer, UByte> defaultValue) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$getOrElse$0");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= UByteArray.o(bArr)) ? ((UByte) defaultValue.invoke(Integer.valueOf(i3))).f() : UByteArray.l(bArr, i3);
    }

    /* JADX INFO: renamed from: getOrNull-PpDY95g, reason: not valid java name */
    public static final UByte m1768getOrNullPpDY95g(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$getOrNull$0");
        if (i3 < 0 || i3 >= UByteArray.o(bArr)) {
            return null;
        }
        return UByte.a(UByteArray.l(bArr, i3));
    }

    /* JADX INFO: renamed from: getOrNull-nggk6HY, reason: not valid java name */
    public static final UShort m1769getOrNullnggk6HY(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$getOrNull$0");
        if (i3 < 0 || i3 >= UShortArray.o(sArr)) {
            return null;
        }
        return UShort.a(UShortArray.l(sArr, i3));
    }

    /* JADX INFO: renamed from: getOrNull-qFRl0hI, reason: not valid java name */
    public static final UInt m1770getOrNullqFRl0hI(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$getOrNull$0");
        if (i3 < 0 || i3 >= UIntArray.o(iArr)) {
            return null;
        }
        return UInt.a(UIntArray.l(iArr, i3));
    }

    /* JADX INFO: renamed from: getOrNull-r7IrZao, reason: not valid java name */
    public static final ULong m1771getOrNullr7IrZao(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$getOrNull$0");
        if (i3 < 0 || i3 >= ULongArray.o(jArr)) {
            return null;
        }
        return ULong.a(ULongArray.l(jArr, i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupBy--_j2Y-Q, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m1772groupBy_j2YQ(long[] jArr, Function1<? super ULong, ? extends K> keySelector, Function1<? super ULong, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$groupBy$0");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            Object objInvoke = keySelector.invoke(ULong.a(jL));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(ULong.a(jL)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupBy-3bBvP4M, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m1773groupBy3bBvP4M(short[] sArr, Function1<? super UShort, ? extends K> keySelector, Function1<? super UShort, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$groupBy$0");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            Object objInvoke = keySelector.invoke(UShort.a(sL));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(UShort.a(sL)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-JOV_ifY, reason: not valid java name */
    private static final <K> Map<K, List<UByte>> m1774groupByJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$groupBy$0");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            Object objInvoke = keySelector.invoke(UByte.a(bL));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(UByte.a(bL));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupBy-L4rlFek, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m1775groupByL4rlFek(int[] iArr, Function1<? super UInt, ? extends K> keySelector, Function1<? super UInt, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$groupBy$0");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            Object objInvoke = keySelector.invoke(UInt.a(iL));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(UInt.a(iL)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-MShoTSo, reason: not valid java name */
    private static final <K> Map<K, List<ULong>> m1776groupByMShoTSo(long[] jArr, Function1<? super ULong, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$groupBy$0");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            Object objInvoke = keySelector.invoke(ULong.a(jL));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(ULong.a(jL));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupBy-bBsjw1Y, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m1777groupBybBsjw1Y(byte[] bArr, Function1<? super UByte, ? extends K> keySelector, Function1<? super UByte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$groupBy$0");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            Object objInvoke = keySelector.invoke(UByte.a(bL));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(UByte.a(bL)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-jgv0xPQ, reason: not valid java name */
    private static final <K> Map<K, List<UInt>> m1778groupByjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$groupBy$0");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            Object objInvoke = keySelector.invoke(UInt.a(iL));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(UInt.a(iL));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-xTcfx_M, reason: not valid java name */
    private static final <K> Map<K, List<UShort>> m1779groupByxTcfx_M(short[] sArr, Function1<? super UShort, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$groupBy$0");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            Object objInvoke = keySelector.invoke(UShort.a(sL));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(UShort.a(sL));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupByTo-4D70W2E, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<UInt>>> M m1780groupByTo4D70W2E(int[] iArr, M destination, Function1<? super UInt, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$groupByTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            Object objInvoke = keySelector.invoke(UInt.a(iL));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(UInt.a(iL));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-H21X9dk, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<UByte>>> M m1781groupByToH21X9dk(byte[] bArr, M destination, Function1<? super UByte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$groupByTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            Object objInvoke = keySelector.invoke(UByte.a(bL));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(UByte.a(bL));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupByTo-JM6gNCM, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m1782groupByToJM6gNCM(int[] iArr, M destination, Function1<? super UInt, ? extends K> keySelector, Function1<? super UInt, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$groupByTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            Object objInvoke = keySelector.invoke(UInt.a(iL));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(UInt.a(iL)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupByTo-QxgOkWg, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m1783groupByToQxgOkWg(long[] jArr, M destination, Function1<? super ULong, ? extends K> keySelector, Function1<? super ULong, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$groupByTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            Object objInvoke = keySelector.invoke(ULong.a(jL));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(ULong.a(jL)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-X6OPwNk, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<ULong>>> M m1784groupByToX6OPwNk(long[] jArr, M destination, Function1<? super ULong, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$groupByTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            Object objInvoke = keySelector.invoke(ULong.a(jL));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(ULong.a(jL));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-ciTST-8, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<UShort>>> M m1785groupByTociTST8(short[] sArr, M destination, Function1<? super UShort, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$groupByTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            Object objInvoke = keySelector.invoke(UShort.a(sL));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(UShort.a(sL));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupByTo-q8RuPII, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m1786groupByToq8RuPII(short[] sArr, M destination, Function1<? super UShort, ? extends K> keySelector, Function1<? super UShort, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$groupByTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            Object objInvoke = keySelector.invoke(UShort.a(sL));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(UShort.a(sL)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: groupByTo-qOZmbk8, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m1787groupByToqOZmbk8(byte[] bArr, M destination, Function1<? super UByte, ? extends K> keySelector, Function1<? super UByte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$groupByTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            Object objInvoke = keySelector.invoke(UByte.a(bL));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(UByte.a(bL)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: indexOf-3uqUaXg, reason: not valid java name */
    private static final int m1788indexOf3uqUaXg(long[] jArr, long j3) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$indexOf$0");
        return ArraysKt.indexOf(jArr, j3);
    }

    /* JADX INFO: renamed from: indexOf-XzdR7RA, reason: not valid java name */
    private static final int m1789indexOfXzdR7RA(short[] sArr, short s2) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$indexOf$0");
        return ArraysKt.indexOf(sArr, s2);
    }

    /* JADX INFO: renamed from: indexOf-gMuBH34, reason: not valid java name */
    private static final int m1790indexOfgMuBH34(byte[] bArr, byte b3) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$indexOf$0");
        return ArraysKt.indexOf(bArr, b3);
    }

    /* JADX INFO: renamed from: indexOf-uWY9BYg, reason: not valid java name */
    private static final int m1791indexOfuWY9BYg(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$indexOf$0");
        return ArraysKt.indexOf(iArr, i3);
    }

    /* JADX INFO: renamed from: indexOfFirst-JOV_ifY, reason: not valid java name */
    private static final int m1792indexOfFirstJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$indexOfFirst$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(UByte.a(UByte.b(bArr[i3])))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfFirst-MShoTSo, reason: not valid java name */
    private static final int m1793indexOfFirstMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$indexOfFirst$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(ULong.a(ULong.b(jArr[i3])))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfFirst-jgv0xPQ, reason: not valid java name */
    private static final int m1794indexOfFirstjgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$indexOfFirst$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(UInt.a(UInt.b(iArr[i3])))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfFirst-xTcfx_M, reason: not valid java name */
    private static final int m1795indexOfFirstxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$indexOfFirst$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(UShort.a(UShort.b(sArr[i3])))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-JOV_ifY, reason: not valid java name */
    private static final int m1796indexOfLastJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$indexOfLast$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(UByte.a(UByte.b(bArr[length])))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-MShoTSo, reason: not valid java name */
    private static final int m1797indexOfLastMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$indexOfLast$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(ULong.a(ULong.b(jArr[length])))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-jgv0xPQ, reason: not valid java name */
    private static final int m1798indexOfLastjgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$indexOfLast$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(UInt.a(UInt.b(iArr[length])))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-xTcfx_M, reason: not valid java name */
    private static final int m1799indexOfLastxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$indexOfLast$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(UShort.a(UShort.b(sArr[length])))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: last--ajY-9A, reason: not valid java name */
    private static final int m1800lastajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$last$0");
        return UInt.b(ArraysKt.last(iArr));
    }

    /* JADX INFO: renamed from: last-GBYM_sE, reason: not valid java name */
    private static final byte m1801lastGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$last$0");
        return UByte.b(ArraysKt.last(bArr));
    }

    /* JADX INFO: renamed from: last-MShoTSo, reason: not valid java name */
    private static final long m1803lastMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$last$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr) - 1;
        if (iO >= 0) {
            while (true) {
                int i3 = iO - 1;
                long jL = ULongArray.l(jArr, iO);
                if (!((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    iO = i3;
                } else {
                    return jL;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: last-QwZRm1k, reason: not valid java name */
    private static final long m1804lastQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$last$0");
        return ULong.b(ArraysKt.last(jArr));
    }

    /* JADX INFO: renamed from: last-jgv0xPQ, reason: not valid java name */
    private static final int m1805lastjgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$last$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr) - 1;
        if (iO >= 0) {
            while (true) {
                int i3 = iO - 1;
                int iL = UIntArray.l(iArr, iO);
                if (!((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    iO = i3;
                } else {
                    return iL;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: last-rL5Bavg, reason: not valid java name */
    private static final short m1806lastrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$last$0");
        return UShort.b(ArraysKt.last(sArr));
    }

    /* JADX INFO: renamed from: last-xTcfx_M, reason: not valid java name */
    private static final short m1807lastxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$last$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr) - 1;
        if (iO >= 0) {
            while (true) {
                int i3 = iO - 1;
                short sL = UShortArray.l(sArr, iO);
                if (!((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    iO = i3;
                } else {
                    return sL;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: lastIndexOf-3uqUaXg, reason: not valid java name */
    private static final int m1808lastIndexOf3uqUaXg(long[] jArr, long j3) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$lastIndexOf$0");
        return ArraysKt.lastIndexOf(jArr, j3);
    }

    /* JADX INFO: renamed from: lastIndexOf-XzdR7RA, reason: not valid java name */
    private static final int m1809lastIndexOfXzdR7RA(short[] sArr, short s2) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$lastIndexOf$0");
        return ArraysKt.lastIndexOf(sArr, s2);
    }

    /* JADX INFO: renamed from: lastIndexOf-gMuBH34, reason: not valid java name */
    private static final int m1810lastIndexOfgMuBH34(byte[] bArr, byte b3) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$lastIndexOf$0");
        return ArraysKt.lastIndexOf(bArr, b3);
    }

    /* JADX INFO: renamed from: lastIndexOf-uWY9BYg, reason: not valid java name */
    private static final int m1811lastIndexOfuWY9BYg(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$lastIndexOf$0");
        return ArraysKt.lastIndexOf(iArr, i3);
    }

    /* JADX INFO: renamed from: lastOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m1812lastOrNullajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$lastOrNull$0");
        if (UIntArray.q(iArr)) {
            return null;
        }
        return UInt.a(UIntArray.l(iArr, UIntArray.o(iArr) - 1));
    }

    /* JADX INFO: renamed from: lastOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m1813lastOrNullGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$lastOrNull$0");
        if (UByteArray.q(bArr)) {
            return null;
        }
        return UByte.a(UByteArray.l(bArr, UByteArray.o(bArr) - 1));
    }

    /* JADX INFO: renamed from: lastOrNull-JOV_ifY, reason: not valid java name */
    private static final UByte m1814lastOrNullJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$lastOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i3 = iO - 1;
            byte bL = UByteArray.l(bArr, iO);
            if (((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                return UByte.a(bL);
            }
            if (i3 < 0) {
                return null;
            }
            iO = i3;
        }
    }

    /* JADX INFO: renamed from: lastOrNull-MShoTSo, reason: not valid java name */
    private static final ULong m1815lastOrNullMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$lastOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i3 = iO - 1;
            long jL = ULongArray.l(jArr, iO);
            if (((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                return ULong.a(jL);
            }
            if (i3 < 0) {
                return null;
            }
            iO = i3;
        }
    }

    /* JADX INFO: renamed from: lastOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m1816lastOrNullQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$lastOrNull$0");
        if (ULongArray.q(jArr)) {
            return null;
        }
        return ULong.a(ULongArray.l(jArr, ULongArray.o(jArr) - 1));
    }

    /* JADX INFO: renamed from: lastOrNull-jgv0xPQ, reason: not valid java name */
    private static final UInt m1817lastOrNulljgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$lastOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i3 = iO - 1;
            int iL = UIntArray.l(iArr, iO);
            if (((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                return UInt.a(iL);
            }
            if (i3 < 0) {
                return null;
            }
            iO = i3;
        }
    }

    /* JADX INFO: renamed from: lastOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m1818lastOrNullrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$lastOrNull$0");
        if (UShortArray.q(sArr)) {
            return null;
        }
        return UShort.a(UShortArray.l(sArr, UShortArray.o(sArr) - 1));
    }

    /* JADX INFO: renamed from: lastOrNull-xTcfx_M, reason: not valid java name */
    private static final UShort m1819lastOrNullxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$lastOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i3 = iO - 1;
            short sL = UShortArray.l(sArr, iO);
            if (((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                return UShort.a(sL);
            }
            if (i3 < 0) {
                return null;
            }
            iO = i3;
        }
    }

    /* JADX INFO: renamed from: map-JOV_ifY, reason: not valid java name */
    private static final <R> List<R> m1820mapJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$map$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UByteArray.o(bArr));
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            arrayList.add(transform.invoke(UByte.a(UByteArray.l(bArr, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: map-MShoTSo, reason: not valid java name */
    private static final <R> List<R> m1821mapMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$map$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(ULongArray.o(jArr));
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            arrayList.add(transform.invoke(ULong.a(ULongArray.l(jArr, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: map-jgv0xPQ, reason: not valid java name */
    private static final <R> List<R> m1822mapjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$map$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UIntArray.o(iArr));
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            arrayList.add(transform.invoke(UInt.a(UIntArray.l(iArr, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: map-xTcfx_M, reason: not valid java name */
    private static final <R> List<R> m1823mapxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$map$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UShortArray.o(sArr));
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            arrayList.add(transform.invoke(UShort.a(UShortArray.l(sArr, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-ELGow60, reason: not valid java name */
    private static final <R> List<R> m1824mapIndexedELGow60(byte[] bArr, Function2<? super Integer, ? super UByte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$mapIndexed$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UByteArray.o(bArr));
        int iO = UByteArray.o(bArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), UByte.a(UByteArray.l(bArr, i3))));
            i3++;
            i4++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-WyvcNBI, reason: not valid java name */
    private static final <R> List<R> m1825mapIndexedWyvcNBI(int[] iArr, Function2<? super Integer, ? super UInt, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$mapIndexed$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UIntArray.o(iArr));
        int iO = UIntArray.o(iArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), UInt.a(UIntArray.l(iArr, i3))));
            i3++;
            i4++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-s8dVfGU, reason: not valid java name */
    private static final <R> List<R> m1826mapIndexeds8dVfGU(long[] jArr, Function2<? super Integer, ? super ULong, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$mapIndexed$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(ULongArray.o(jArr));
        int iO = ULongArray.o(jArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), ULong.a(ULongArray.l(jArr, i3))));
            i3++;
            i4++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-xzaTVY8, reason: not valid java name */
    private static final <R> List<R> m1827mapIndexedxzaTVY8(short[] sArr, Function2<? super Integer, ? super UShort, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$mapIndexed$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(UShortArray.o(sArr));
        int iO = UShortArray.o(sArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), UShort.a(UShortArray.l(sArr, i3))));
            i3++;
            i4++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexedTo--6EtJGI, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1828mapIndexedTo6EtJGI(int[] iArr, C destination, Function2<? super Integer, ? super UInt, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$mapIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UIntArray.o(iArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            destination.add(transform.invoke(Integer.valueOf(i4), UInt.a(UIntArray.l(iArr, i3))));
            i3++;
            i4++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1829mapIndexedToQqktQ3k(short[] sArr, C destination, Function2<? super Integer, ? super UShort, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$mapIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UShortArray.o(sArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            destination.add(transform.invoke(Integer.valueOf(i4), UShort.a(UShortArray.l(sArr, i3))));
            i3++;
            i4++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1830mapIndexedToeNpIKz8(byte[] bArr, C destination, Function2<? super Integer, ? super UByte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$mapIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UByteArray.o(bArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            destination.add(transform.invoke(Integer.valueOf(i4), UByte.a(UByteArray.l(bArr, i3))));
            i3++;
            i4++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1831mapIndexedTope2Q0Dw(long[] jArr, C destination, Function2<? super Integer, ? super ULong, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$mapIndexedTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = ULongArray.o(jArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            destination.add(transform.invoke(Integer.valueOf(i4), ULong.a(ULongArray.l(jArr, i3))));
            i3++;
            i4++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-HqK1JgA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1832mapToHqK1JgA(long[] jArr, C destination, Function1<? super ULong, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$mapTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            destination.add(transform.invoke(ULong.a(ULongArray.l(jArr, i3))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-oEOeDjA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1833mapTooEOeDjA(short[] sArr, C destination, Function1<? super UShort, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$mapTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            destination.add(transform.invoke(UShort.a(UShortArray.l(sArr, i3))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-wU5IKMo, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1834mapTowU5IKMo(int[] iArr, C destination, Function1<? super UInt, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$mapTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            destination.add(transform.invoke(UInt.a(UIntArray.l(iArr, i3))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-wzUQCXU, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m1835mapTowzUQCXU(byte[] bArr, C destination, Function1<? super UByte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$mapTo$0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            destination.add(transform.invoke(UByte.a(UByteArray.l(bArr, i3))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxByOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> ULong m1837maxByOrNullMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxByOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            return null;
        }
        long jL = ULongArray.l(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        if (lastIndex == 0) {
            return ULong.a(jL);
        }
        Comparable comparable = (Comparable) selector.invoke(ULong.a(jL));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jL2 = ULongArray.l(jArr, i3);
                Comparable comparable2 = (Comparable) selector.invoke(ULong.a(jL2));
                if (comparable.compareTo(comparable2) < 0) {
                    jL = jL2;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return ULong.a(jL);
    }

    /* JADX INFO: renamed from: maxByOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UInt m1838maxByOrNulljgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxByOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            return null;
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex == 0) {
            return UInt.a(iL);
        }
        Comparable comparable = (Comparable) selector.invoke(UInt.a(iL));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iL2 = UIntArray.l(iArr, i3);
                Comparable comparable2 = (Comparable) selector.invoke(UInt.a(iL2));
                if (comparable.compareTo(comparable2) < 0) {
                    iL = iL2;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UInt.a(iL);
    }

    /* JADX INFO: renamed from: maxByOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UShort m1839maxByOrNullxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxByOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            return null;
        }
        short sL = UShortArray.l(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        if (lastIndex == 0) {
            return UShort.a(sL);
        }
        Comparable comparable = (Comparable) selector.invoke(UShort.a(sL));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sL2 = UShortArray.l(sArr, i3);
                Comparable comparable2 = (Comparable) selector.invoke(UShort.a(sL2));
                if (comparable.compareTo(comparable2) < 0) {
                    sL = sL2;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UShort.a(sL);
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> int m1841maxByOrThrowU(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            throw new NoSuchElementException();
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(UInt.a(iL));
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iL2 = UIntArray.l(iArr, i3);
                    Comparable comparable2 = (Comparable) selector.invoke(UInt.a(iL2));
                    if (comparable.compareTo(comparable2) < 0) {
                        iL = iL2;
                        comparable = comparable2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return iL;
    }

    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final double m1844maxOfJOV_ifY(byte[] bArr, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final double m1847maxOfMShoTSo(long[] jArr, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final double m1850maxOfjgv0xPQ(int[] iArr, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final double m1853maxOfxTcfx_M(short[] sArr, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Double m1857maxOfOrNullJOV_ifY(byte[] bArr, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final Double m1860maxOfOrNullMShoTSo(long[] jArr, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Double m1863maxOfOrNulljgv0xPQ(int[] iArr, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Double m1866maxOfOrNullxTcfx_M(short[] sArr, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOfWith-5NtCtWE, reason: not valid java name */
    private static final <R> R m1868maxOfWith5NtCtWE(long[] jArr, Comparator<? super R> comparator, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxOfWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            throw new NoSuchElementException();
        }
        R r2 = (Object) selector.invoke(ULong.a(ULongArray.l(jArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(ULong.a(ULongArray.l(jArr, i3)));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOfWith-LTi4i_s, reason: not valid java name */
    private static final <R> R m1869maxOfWithLTi4i_s(byte[] bArr, Comparator<? super R> comparator, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxOfWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            throw new NoSuchElementException();
        }
        R r2 = (Object) selector.invoke(UByte.a(UByteArray.l(bArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UByte.a(UByteArray.l(bArr, i3)));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOfWith-l8EHGbQ, reason: not valid java name */
    private static final <R> R m1870maxOfWithl8EHGbQ(short[] sArr, Comparator<? super R> comparator, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxOfWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            throw new NoSuchElementException();
        }
        R r2 = (Object) selector.invoke(UShort.a(UShortArray.l(sArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UShort.a(UShortArray.l(sArr, i3)));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOfWith-myNOsp4, reason: not valid java name */
    private static final <R> R m1871maxOfWithmyNOsp4(int[] iArr, Comparator<? super R> comparator, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxOfWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            throw new NoSuchElementException();
        }
        R r2 = (Object) selector.invoke(UInt.a(UIntArray.l(iArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UInt.a(UIntArray.l(iArr, i3)));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-5NtCtWE, reason: not valid java name */
    private static final <R> R m1872maxOfWithOrNull5NtCtWE(long[] jArr, Comparator<? super R> comparator, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxOfWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            return null;
        }
        R r2 = (Object) selector.invoke(ULong.a(ULongArray.l(jArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(ULong.a(ULongArray.l(jArr, i3)));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-LTi4i_s, reason: not valid java name */
    private static final <R> R m1873maxOfWithOrNullLTi4i_s(byte[] bArr, Comparator<? super R> comparator, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxOfWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            return null;
        }
        R r2 = (Object) selector.invoke(UByte.a(UByteArray.l(bArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UByte.a(UByteArray.l(bArr, i3)));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-l8EHGbQ, reason: not valid java name */
    private static final <R> R m1874maxOfWithOrNulll8EHGbQ(short[] sArr, Comparator<? super R> comparator, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxOfWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            return null;
        }
        R r2 = (Object) selector.invoke(UShort.a(UShortArray.l(sArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UShort.a(UShortArray.l(sArr, i3)));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-myNOsp4, reason: not valid java name */
    private static final <R> R m1875maxOfWithOrNullmyNOsp4(int[] iArr, Comparator<? super R> comparator, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxOfWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            return null;
        }
        R r2 = (Object) selector.invoke(UInt.a(UIntArray.l(iArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UInt.a(UIntArray.l(iArr, i3)));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m1876maxOrNullajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxOrNull$0");
        if (UIntArray.q(iArr)) {
            return null;
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iL2 = UIntArray.l(iArr, i3);
                if (Integer.compareUnsigned(iL, iL2) < 0) {
                    iL = iL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UInt.a(iL);
    }

    /* JADX INFO: renamed from: maxOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m1877maxOrNullGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxOrNull$0");
        if (UByteArray.q(bArr)) {
            return null;
        }
        byte bL = UByteArray.l(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bL2 = UByteArray.l(bArr, i3);
                if (Intrinsics.compare(bL & 255, bL2 & 255) < 0) {
                    bL = bL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UByte.a(bL);
    }

    /* JADX INFO: renamed from: maxOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m1878maxOrNullQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxOrNull$0");
        if (ULongArray.q(jArr)) {
            return null;
        }
        long jL = ULongArray.l(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jL2 = ULongArray.l(jArr, i3);
                if (Long.compareUnsigned(jL, jL2) < 0) {
                    jL = jL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return ULong.a(jL);
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final int m1881maxOrThrowU(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$max$0");
        if (UIntArray.q(iArr)) {
            throw new NoSuchElementException();
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iL2 = UIntArray.l(iArr, i3);
                if (Integer.compareUnsigned(iL, iL2) < 0) {
                    iL = iL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return iL;
    }

    /* JADX INFO: renamed from: maxWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m1884maxWithOrNullXMRcp5o(byte[] bArr, Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.q(bArr)) {
            return null;
        }
        byte bL = UByteArray.l(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bL2 = UByteArray.l(bArr, i3);
                if (comparator.compare(UByte.a(bL), UByte.a(bL2)) < 0) {
                    bL = bL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UByte.a(bL);
    }

    /* JADX INFO: renamed from: maxWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m1885maxWithOrNullYmdZ_VM(int[] iArr, Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.q(iArr)) {
            return null;
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iL2 = UIntArray.l(iArr, i3);
                if (comparator.compare(UInt.a(iL), UInt.a(iL2)) < 0) {
                    iL = iL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UInt.a(iL);
    }

    /* JADX INFO: renamed from: maxWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m1886maxWithOrNulleOHTfZs(short[] sArr, Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.q(sArr)) {
            return null;
        }
        short sL = UShortArray.l(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sL2 = UShortArray.l(sArr, i3);
                if (comparator.compare(UShort.a(sL), UShort.a(sL2)) < 0) {
                    sL = sL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UShort.a(sL);
    }

    /* JADX INFO: renamed from: maxWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m1887maxWithOrNullzrEWJaI(long[] jArr, Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.q(jArr)) {
            return null;
        }
        long jL = ULongArray.l(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jL2 = ULongArray.l(jArr, i3);
                if (comparator.compare(ULong.a(jL), ULong.a(jL2)) < 0) {
                    jL = jL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return ULong.a(jL);
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final int m1889maxWithOrThrowU(int[] iArr, Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.q(iArr)) {
            throw new NoSuchElementException();
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iL2 = UIntArray.l(iArr, i3);
                if (comparator.compare(UInt.a(iL), UInt.a(iL2)) < 0) {
                    iL = iL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return iL;
    }

    /* JADX INFO: renamed from: minByOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UByte m1892minByOrNullJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minByOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            return null;
        }
        byte bL = UByteArray.l(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        if (lastIndex == 0) {
            return UByte.a(bL);
        }
        Comparable comparable = (Comparable) selector.invoke(UByte.a(bL));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bL2 = UByteArray.l(bArr, i3);
                Comparable comparable2 = (Comparable) selector.invoke(UByte.a(bL2));
                if (comparable.compareTo(comparable2) > 0) {
                    bL = bL2;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UByte.a(bL);
    }

    /* JADX INFO: renamed from: minByOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> ULong m1893minByOrNullMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minByOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            return null;
        }
        long jL = ULongArray.l(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        if (lastIndex == 0) {
            return ULong.a(jL);
        }
        Comparable comparable = (Comparable) selector.invoke(ULong.a(jL));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jL2 = ULongArray.l(jArr, i3);
                Comparable comparable2 = (Comparable) selector.invoke(ULong.a(jL2));
                if (comparable.compareTo(comparable2) > 0) {
                    jL = jL2;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return ULong.a(jL);
    }

    /* JADX INFO: renamed from: minByOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UInt m1894minByOrNulljgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minByOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            return null;
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex == 0) {
            return UInt.a(iL);
        }
        Comparable comparable = (Comparable) selector.invoke(UInt.a(iL));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iL2 = UIntArray.l(iArr, i3);
                Comparable comparable2 = (Comparable) selector.invoke(UInt.a(iL2));
                if (comparable.compareTo(comparable2) > 0) {
                    iL = iL2;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UInt.a(iL);
    }

    /* JADX INFO: renamed from: minByOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UShort m1895minByOrNullxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minByOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            return null;
        }
        short sL = UShortArray.l(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        if (lastIndex == 0) {
            return UShort.a(sL);
        }
        Comparable comparable = (Comparable) selector.invoke(UShort.a(sL));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sL2 = UShortArray.l(sArr, i3);
                Comparable comparable2 = (Comparable) selector.invoke(UShort.a(sL2));
                if (comparable.compareTo(comparable2) > 0) {
                    sL = sL2;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UShort.a(sL);
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> int m1897minByOrThrowU(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            throw new NoSuchElementException();
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(UInt.a(iL));
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iL2 = UIntArray.l(iArr, i3);
                    Comparable comparable2 = (Comparable) selector.invoke(UInt.a(iL2));
                    if (comparable.compareTo(comparable2) > 0) {
                        iL = iL2;
                        comparable = comparable2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return iL;
    }

    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final double m1900minOfJOV_ifY(byte[] bArr, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final double m1903minOfMShoTSo(long[] jArr, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final double m1906minOfjgv0xPQ(int[] iArr, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final double m1909minOfxTcfx_M(short[] sArr, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Double m1913minOfOrNullJOV_ifY(byte[] bArr, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final Double m1916minOfOrNullMShoTSo(long[] jArr, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Double m1919minOfOrNulljgv0xPQ(int[] iArr, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Double m1922minOfOrNullxTcfx_M(short[] sArr, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, 0)))).doubleValue();
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfWith-5NtCtWE, reason: not valid java name */
    private static final <R> R m1924minOfWith5NtCtWE(long[] jArr, Comparator<? super R> comparator, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minOfWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            throw new NoSuchElementException();
        }
        R r2 = (Object) selector.invoke(ULong.a(ULongArray.l(jArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(ULong.a(ULongArray.l(jArr, i3)));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOfWith-LTi4i_s, reason: not valid java name */
    private static final <R> R m1925minOfWithLTi4i_s(byte[] bArr, Comparator<? super R> comparator, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minOfWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            throw new NoSuchElementException();
        }
        R r2 = (Object) selector.invoke(UByte.a(UByteArray.l(bArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UByte.a(UByteArray.l(bArr, i3)));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOfWith-l8EHGbQ, reason: not valid java name */
    private static final <R> R m1926minOfWithl8EHGbQ(short[] sArr, Comparator<? super R> comparator, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minOfWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            throw new NoSuchElementException();
        }
        R r2 = (Object) selector.invoke(UShort.a(UShortArray.l(sArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UShort.a(UShortArray.l(sArr, i3)));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOfWith-myNOsp4, reason: not valid java name */
    private static final <R> R m1927minOfWithmyNOsp4(int[] iArr, Comparator<? super R> comparator, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minOfWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            throw new NoSuchElementException();
        }
        R r2 = (Object) selector.invoke(UInt.a(UIntArray.l(iArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UInt.a(UIntArray.l(iArr, i3)));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-5NtCtWE, reason: not valid java name */
    private static final <R> R m1928minOfWithOrNull5NtCtWE(long[] jArr, Comparator<? super R> comparator, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minOfWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            return null;
        }
        R r2 = (Object) selector.invoke(ULong.a(ULongArray.l(jArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(ULong.a(ULongArray.l(jArr, i3)));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-LTi4i_s, reason: not valid java name */
    private static final <R> R m1929minOfWithOrNullLTi4i_s(byte[] bArr, Comparator<? super R> comparator, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minOfWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            return null;
        }
        R r2 = (Object) selector.invoke(UByte.a(UByteArray.l(bArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UByte.a(UByteArray.l(bArr, i3)));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-l8EHGbQ, reason: not valid java name */
    private static final <R> R m1930minOfWithOrNulll8EHGbQ(short[] sArr, Comparator<? super R> comparator, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minOfWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            return null;
        }
        R r2 = (Object) selector.invoke(UShort.a(UShortArray.l(sArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UShort.a(UShortArray.l(sArr, i3)));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-myNOsp4, reason: not valid java name */
    private static final <R> R m1931minOfWithOrNullmyNOsp4(int[] iArr, Comparator<? super R> comparator, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minOfWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            return null;
        }
        R r2 = (Object) selector.invoke(UInt.a(UIntArray.l(iArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(UInt.a(UIntArray.l(iArr, i3)));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m1932minOrNullajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minOrNull$0");
        if (UIntArray.q(iArr)) {
            return null;
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iL2 = UIntArray.l(iArr, i3);
                if (Integer.compareUnsigned(iL, iL2) > 0) {
                    iL = iL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UInt.a(iL);
    }

    /* JADX INFO: renamed from: minOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m1933minOrNullGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minOrNull$0");
        if (UByteArray.q(bArr)) {
            return null;
        }
        byte bL = UByteArray.l(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bL2 = UByteArray.l(bArr, i3);
                if (Intrinsics.compare(bL & 255, bL2 & 255) > 0) {
                    bL = bL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UByte.a(bL);
    }

    /* JADX INFO: renamed from: minOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m1935minOrNullrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minOrNull$0");
        if (UShortArray.q(sArr)) {
            return null;
        }
        short sL = UShortArray.l(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sL2 = UShortArray.l(sArr, i3);
                if (Intrinsics.compare(sL & 65535, 65535 & sL2) > 0) {
                    sL = sL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UShort.a(sL);
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final int m1937minOrThrowU(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$min$0");
        if (UIntArray.q(iArr)) {
            throw new NoSuchElementException();
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iL2 = UIntArray.l(iArr, i3);
                if (Integer.compareUnsigned(iL, iL2) > 0) {
                    iL = iL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return iL;
    }

    /* JADX INFO: renamed from: minWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m1940minWithOrNullXMRcp5o(byte[] bArr, Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.q(bArr)) {
            return null;
        }
        byte bL = UByteArray.l(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bL2 = UByteArray.l(bArr, i3);
                if (comparator.compare(UByte.a(bL), UByte.a(bL2)) > 0) {
                    bL = bL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UByte.a(bL);
    }

    /* JADX INFO: renamed from: minWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m1941minWithOrNullYmdZ_VM(int[] iArr, Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.q(iArr)) {
            return null;
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iL2 = UIntArray.l(iArr, i3);
                if (comparator.compare(UInt.a(iL), UInt.a(iL2)) > 0) {
                    iL = iL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UInt.a(iL);
    }

    /* JADX INFO: renamed from: minWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m1942minWithOrNulleOHTfZs(short[] sArr, Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.q(sArr)) {
            return null;
        }
        short sL = UShortArray.l(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sL2 = UShortArray.l(sArr, i3);
                if (comparator.compare(UShort.a(sL), UShort.a(sL2)) > 0) {
                    sL = sL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UShort.a(sL);
    }

    /* JADX INFO: renamed from: minWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m1943minWithOrNullzrEWJaI(long[] jArr, Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minWithOrNull$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.q(jArr)) {
            return null;
        }
        long jL = ULongArray.l(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jL2 = ULongArray.l(jArr, i3);
                if (comparator.compare(ULong.a(jL), ULong.a(jL2)) > 0) {
                    jL = jL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return ULong.a(jL);
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final int m1945minWithOrThrowU(int[] iArr, Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.q(iArr)) {
            throw new NoSuchElementException();
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iL2 = UIntArray.l(iArr, i3);
                if (comparator.compare(UInt.a(iL), UInt.a(iL2)) > 0) {
                    iL = iL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return iL;
    }

    /* JADX INFO: renamed from: none--ajY-9A, reason: not valid java name */
    private static final boolean m1948noneajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$none$0");
        return UIntArray.q(iArr);
    }

    /* JADX INFO: renamed from: none-GBYM_sE, reason: not valid java name */
    private static final boolean m1949noneGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$none$0");
        return UByteArray.q(bArr);
    }

    /* JADX INFO: renamed from: none-JOV_ifY, reason: not valid java name */
    private static final boolean m1950noneJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$none$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (((Boolean) predicate.invoke(UByte.a(UByteArray.l(bArr, i3)))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: none-MShoTSo, reason: not valid java name */
    private static final boolean m1951noneMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$none$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (((Boolean) predicate.invoke(ULong.a(ULongArray.l(jArr, i3)))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: none-QwZRm1k, reason: not valid java name */
    private static final boolean m1952noneQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$none$0");
        return ULongArray.q(jArr);
    }

    /* JADX INFO: renamed from: none-jgv0xPQ, reason: not valid java name */
    private static final boolean m1953nonejgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$none$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (((Boolean) predicate.invoke(UInt.a(UIntArray.l(iArr, i3)))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: none-rL5Bavg, reason: not valid java name */
    private static final boolean m1954nonerL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$none$0");
        return UShortArray.q(sArr);
    }

    /* JADX INFO: renamed from: none-xTcfx_M, reason: not valid java name */
    private static final boolean m1955nonexTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$none$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (((Boolean) predicate.invoke(UShort.a(UShortArray.l(sArr, i3)))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: onEach-JOV_ifY, reason: not valid java name */
    private static final byte[] m1956onEachJOV_ifY(byte[] bArr, Function1<? super UByte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$onEach$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            action.invoke(UByte.a(UByteArray.l(bArr, i3)));
        }
        return bArr;
    }

    /* JADX INFO: renamed from: onEach-MShoTSo, reason: not valid java name */
    private static final long[] m1957onEachMShoTSo(long[] jArr, Function1<? super ULong, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$onEach$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            action.invoke(ULong.a(ULongArray.l(jArr, i3)));
        }
        return jArr;
    }

    /* JADX INFO: renamed from: onEach-jgv0xPQ, reason: not valid java name */
    private static final int[] m1958onEachjgv0xPQ(int[] iArr, Function1<? super UInt, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$onEach$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            action.invoke(UInt.a(UIntArray.l(iArr, i3)));
        }
        return iArr;
    }

    /* JADX INFO: renamed from: onEach-xTcfx_M, reason: not valid java name */
    private static final short[] m1959onEachxTcfx_M(short[] sArr, Function1<? super UShort, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$onEach$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            action.invoke(UShort.a(UShortArray.l(sArr, i3)));
        }
        return sArr;
    }

    /* JADX INFO: renamed from: onEachIndexed-ELGow60, reason: not valid java name */
    private static final byte[] m1960onEachIndexedELGow60(byte[] bArr, Function2<? super Integer, ? super UByte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$onEachIndexed$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UByteArray.o(bArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            action.invoke(Integer.valueOf(i4), UByte.a(UByteArray.l(bArr, i3)));
            i3++;
            i4++;
        }
        return bArr;
    }

    /* JADX INFO: renamed from: onEachIndexed-WyvcNBI, reason: not valid java name */
    private static final int[] m1961onEachIndexedWyvcNBI(int[] iArr, Function2<? super Integer, ? super UInt, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$onEachIndexed$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UIntArray.o(iArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            action.invoke(Integer.valueOf(i4), UInt.a(UIntArray.l(iArr, i3)));
            i3++;
            i4++;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: onEachIndexed-s8dVfGU, reason: not valid java name */
    private static final long[] m1962onEachIndexeds8dVfGU(long[] jArr, Function2<? super Integer, ? super ULong, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$onEachIndexed$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = ULongArray.o(jArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            action.invoke(Integer.valueOf(i4), ULong.a(ULongArray.l(jArr, i3)));
            i3++;
            i4++;
        }
        return jArr;
    }

    /* JADX INFO: renamed from: onEachIndexed-xzaTVY8, reason: not valid java name */
    private static final short[] m1963onEachIndexedxzaTVY8(short[] sArr, Function2<? super Integer, ? super UShort, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$onEachIndexed$0");
        Intrinsics.checkNotNullParameter(action, "action");
        int iO = UShortArray.o(sArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iO) {
            action.invoke(Integer.valueOf(i4), UShort.a(UShortArray.l(sArr, i3)));
            i3++;
            i4++;
        }
        return sArr;
    }

    /* JADX INFO: renamed from: plus-3uqUaXg, reason: not valid java name */
    private static final long[] m1964plus3uqUaXg(long[] jArr, long j3) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$plus$0");
        return ULongArray.d(ArraysKt.plus(jArr, j3));
    }

    /* JADX INFO: renamed from: plus-CFIt9YE, reason: not valid java name */
    public static final int[] m1965plusCFIt9YE(int[] iArr, Collection<UInt> elements) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$plus$0");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iO = UIntArray.o(iArr);
        int[] iArrCopyOf = Arrays.copyOf(iArr, UIntArray.o(iArr) + elements.size());
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        Iterator<UInt> it = elements.iterator();
        while (it.hasNext()) {
            iArrCopyOf[iO] = it.next().f();
            iO++;
        }
        return UIntArray.d(iArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-XzdR7RA, reason: not valid java name */
    private static final short[] m1966plusXzdR7RA(short[] sArr, short s2) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$plus$0");
        return UShortArray.d(ArraysKt.plus(sArr, s2));
    }

    /* JADX INFO: renamed from: plus-ctEhBpI, reason: not valid java name */
    private static final int[] m1967plusctEhBpI(int[] iArr, int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$plus$0");
        Intrinsics.checkNotNullParameter(iArr2, "$v$c$kotlin-UIntArray$-elements$0");
        return UIntArray.d(ArraysKt.plus(iArr, iArr2));
    }

    /* JADX INFO: renamed from: plus-gMuBH34, reason: not valid java name */
    private static final byte[] m1968plusgMuBH34(byte[] bArr, byte b3) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$plus$0");
        return UByteArray.d(ArraysKt.plus(bArr, b3));
    }

    /* JADX INFO: renamed from: plus-kdPth3s, reason: not valid java name */
    private static final byte[] m1969pluskdPth3s(byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$plus$0");
        Intrinsics.checkNotNullParameter(bArr2, "$v$c$kotlin-UByteArray$-elements$0");
        return UByteArray.d(ArraysKt.plus(bArr, bArr2));
    }

    /* JADX INFO: renamed from: plus-kzHmqpY, reason: not valid java name */
    public static final long[] m1970pluskzHmqpY(long[] jArr, Collection<ULong> elements) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$plus$0");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iO = ULongArray.o(jArr);
        long[] jArrCopyOf = Arrays.copyOf(jArr, ULongArray.o(jArr) + elements.size());
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        Iterator<ULong> it = elements.iterator();
        while (it.hasNext()) {
            jArrCopyOf[iO] = it.next().g();
            iO++;
        }
        return ULongArray.d(jArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-mazbYpA, reason: not valid java name */
    private static final short[] m1971plusmazbYpA(short[] sArr, short[] sArr2) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$plus$0");
        Intrinsics.checkNotNullParameter(sArr2, "$v$c$kotlin-UShortArray$-elements$0");
        return UShortArray.d(ArraysKt.plus(sArr, sArr2));
    }

    /* JADX INFO: renamed from: plus-ojwP5H8, reason: not valid java name */
    public static final short[] m1972plusojwP5H8(short[] sArr, Collection<UShort> elements) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$plus$0");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iO = UShortArray.o(sArr);
        short[] sArrCopyOf = Arrays.copyOf(sArr, UShortArray.o(sArr) + elements.size());
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        Iterator<UShort> it = elements.iterator();
        while (it.hasNext()) {
            sArrCopyOf[iO] = it.next().f();
            iO++;
        }
        return UShortArray.d(sArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-uWY9BYg, reason: not valid java name */
    private static final int[] m1973plusuWY9BYg(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$plus$0");
        return UIntArray.d(ArraysKt.plus(iArr, i3));
    }

    /* JADX INFO: renamed from: plus-xo_DsdI, reason: not valid java name */
    public static final byte[] m1975plusxo_DsdI(byte[] bArr, Collection<UByte> elements) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$plus$0");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iO = UByteArray.o(bArr);
        byte[] bArrCopyOf = Arrays.copyOf(bArr, UByteArray.o(bArr) + elements.size());
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        Iterator<UByte> it = elements.iterator();
        while (it.hasNext()) {
            bArrCopyOf[iO] = it.next().f();
            iO++;
        }
        return UByteArray.d(bArrCopyOf);
    }

    /* JADX INFO: renamed from: random--ajY-9A, reason: not valid java name */
    private static final int m1976randomajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$random$0");
        return m1977random2D5oskM(iArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: random-2D5oskM, reason: not valid java name */
    public static final int m1977random2D5oskM(int[] iArr, Random random) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$random$0");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UIntArray.q(iArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UIntArray.l(iArr, random.j(UIntArray.o(iArr)));
    }

    /* JADX INFO: renamed from: random-GBYM_sE, reason: not valid java name */
    private static final byte m1978randomGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$random$0");
        return m1981randomoSF2wD8(bArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: random-JzugnMA, reason: not valid java name */
    public static final long m1979randomJzugnMA(long[] jArr, Random random) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$random$0");
        Intrinsics.checkNotNullParameter(random, "random");
        if (ULongArray.q(jArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return ULongArray.l(jArr, random.j(ULongArray.o(jArr)));
    }

    /* JADX INFO: renamed from: random-QwZRm1k, reason: not valid java name */
    private static final long m1980randomQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$random$0");
        return m1979randomJzugnMA(jArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: random-oSF2wD8, reason: not valid java name */
    public static final byte m1981randomoSF2wD8(byte[] bArr, Random random) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$random$0");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UByteArray.q(bArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UByteArray.l(bArr, random.j(UByteArray.o(bArr)));
    }

    /* JADX INFO: renamed from: random-rL5Bavg, reason: not valid java name */
    private static final short m1982randomrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$random$0");
        return m1983randoms5X_as8(sArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: random-s5X_as8, reason: not valid java name */
    public static final short m1983randoms5X_as8(short[] sArr, Random random) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$random$0");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UShortArray.q(sArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UShortArray.l(sArr, random.j(UShortArray.o(sArr)));
    }

    /* JADX INFO: renamed from: randomOrNull--ajY-9A, reason: not valid java name */
    private static final UInt m1984randomOrNullajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$randomOrNull$0");
        return m1985randomOrNull2D5oskM(iArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: randomOrNull-2D5oskM, reason: not valid java name */
    public static final UInt m1985randomOrNull2D5oskM(int[] iArr, Random random) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$randomOrNull$0");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UIntArray.q(iArr)) {
            return null;
        }
        return UInt.a(UIntArray.l(iArr, random.j(UIntArray.o(iArr))));
    }

    /* JADX INFO: renamed from: randomOrNull-GBYM_sE, reason: not valid java name */
    private static final UByte m1986randomOrNullGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$randomOrNull$0");
        return m1989randomOrNulloSF2wD8(bArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: randomOrNull-JzugnMA, reason: not valid java name */
    public static final ULong m1987randomOrNullJzugnMA(long[] jArr, Random random) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$randomOrNull$0");
        Intrinsics.checkNotNullParameter(random, "random");
        if (ULongArray.q(jArr)) {
            return null;
        }
        return ULong.a(ULongArray.l(jArr, random.j(ULongArray.o(jArr))));
    }

    /* JADX INFO: renamed from: randomOrNull-QwZRm1k, reason: not valid java name */
    private static final ULong m1988randomOrNullQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$randomOrNull$0");
        return m1987randomOrNullJzugnMA(jArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: randomOrNull-oSF2wD8, reason: not valid java name */
    public static final UByte m1989randomOrNulloSF2wD8(byte[] bArr, Random random) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$randomOrNull$0");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UByteArray.q(bArr)) {
            return null;
        }
        return UByte.a(UByteArray.l(bArr, random.j(UByteArray.o(bArr))));
    }

    /* JADX INFO: renamed from: randomOrNull-rL5Bavg, reason: not valid java name */
    private static final UShort m1990randomOrNullrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$randomOrNull$0");
        return m1991randomOrNulls5X_as8(sArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: randomOrNull-s5X_as8, reason: not valid java name */
    public static final UShort m1991randomOrNulls5X_as8(short[] sArr, Random random) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$randomOrNull$0");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UShortArray.q(sArr)) {
            return null;
        }
        return UShort.a(UShortArray.l(sArr, random.j(UShortArray.o(sArr))));
    }

    /* JADX INFO: renamed from: reduce-ELGow60, reason: not valid java name */
    private static final byte m1992reduceELGow60(byte[] bArr, Function2<? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reduce$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.q(bArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bL = UByteArray.l(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bL = ((UByte) operation.invoke(UByte.a(bL), UByte.a(UByteArray.l(bArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return bL;
    }

    /* JADX INFO: renamed from: reduce-WyvcNBI, reason: not valid java name */
    private static final int m1993reduceWyvcNBI(int[] iArr, Function2<? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reduce$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.q(iArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iL = ((UInt) operation.invoke(UInt.a(iL), UInt.a(UIntArray.l(iArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return iL;
    }

    /* JADX INFO: renamed from: reduce-s8dVfGU, reason: not valid java name */
    private static final long m1994reduces8dVfGU(long[] jArr, Function2<? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reduce$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.q(jArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jL = ULongArray.l(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jL = ((ULong) operation.invoke(ULong.a(jL), ULong.a(ULongArray.l(jArr, i3)))).g();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return jL;
    }

    /* JADX INFO: renamed from: reduce-xzaTVY8, reason: not valid java name */
    private static final short m1995reducexzaTVY8(short[] sArr, Function2<? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reduce$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.q(sArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sL = UShortArray.l(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sL = ((UShort) operation.invoke(UShort.a(sL), UShort.a(UShortArray.l(sArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return sL;
    }

    /* JADX INFO: renamed from: reduceIndexed-D40WMg8, reason: not valid java name */
    private static final int m1996reduceIndexedD40WMg8(int[] iArr, Function3<? super Integer, ? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reduceIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.q(iArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iL = ((UInt) operation.invoke(Integer.valueOf(i3), UInt.a(iL), UInt.a(UIntArray.l(iArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return iL;
    }

    /* JADX INFO: renamed from: reduceIndexed-EOyYB1Y, reason: not valid java name */
    private static final byte m1997reduceIndexedEOyYB1Y(byte[] bArr, Function3<? super Integer, ? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reduceIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.q(bArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bL = UByteArray.l(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bL = ((UByte) operation.invoke(Integer.valueOf(i3), UByte.a(bL), UByte.a(UByteArray.l(bArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return bL;
    }

    /* JADX INFO: renamed from: reduceIndexed-aLgx1Fo, reason: not valid java name */
    private static final short m1998reduceIndexedaLgx1Fo(short[] sArr, Function3<? super Integer, ? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reduceIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.q(sArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sL = UShortArray.l(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sL = ((UShort) operation.invoke(Integer.valueOf(i3), UShort.a(sL), UShort.a(UShortArray.l(sArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return sL;
    }

    /* JADX INFO: renamed from: reduceIndexed-z1zDJgo, reason: not valid java name */
    private static final long m1999reduceIndexedz1zDJgo(long[] jArr, Function3<? super Integer, ? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reduceIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.q(jArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jL = ULongArray.l(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jL = ((ULong) operation.invoke(Integer.valueOf(i3), ULong.a(jL), ULong.a(ULongArray.l(jArr, i3)))).g();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return jL;
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-D40WMg8, reason: not valid java name */
    private static final UInt m2000reduceIndexedOrNullD40WMg8(int[] iArr, Function3<? super Integer, ? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reduceIndexedOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.q(iArr)) {
            return null;
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iL = ((UInt) operation.invoke(Integer.valueOf(i3), UInt.a(iL), UInt.a(UIntArray.l(iArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UInt.a(iL);
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-EOyYB1Y, reason: not valid java name */
    private static final UByte m2001reduceIndexedOrNullEOyYB1Y(byte[] bArr, Function3<? super Integer, ? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reduceIndexedOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.q(bArr)) {
            return null;
        }
        byte bL = UByteArray.l(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bL = ((UByte) operation.invoke(Integer.valueOf(i3), UByte.a(bL), UByte.a(UByteArray.l(bArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UByte.a(bL);
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-aLgx1Fo, reason: not valid java name */
    private static final UShort m2002reduceIndexedOrNullaLgx1Fo(short[] sArr, Function3<? super Integer, ? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reduceIndexedOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.q(sArr)) {
            return null;
        }
        short sL = UShortArray.l(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sL = ((UShort) operation.invoke(Integer.valueOf(i3), UShort.a(sL), UShort.a(UShortArray.l(sArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UShort.a(sL);
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-z1zDJgo, reason: not valid java name */
    private static final ULong m2003reduceIndexedOrNullz1zDJgo(long[] jArr, Function3<? super Integer, ? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reduceIndexedOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.q(jArr)) {
            return null;
        }
        long jL = ULongArray.l(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jL = ((ULong) operation.invoke(Integer.valueOf(i3), ULong.a(jL), ULong.a(ULongArray.l(jArr, i3)))).g();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return ULong.a(jL);
    }

    /* JADX INFO: renamed from: reduceOrNull-ELGow60, reason: not valid java name */
    private static final UByte m2004reduceOrNullELGow60(byte[] bArr, Function2<? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reduceOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.q(bArr)) {
            return null;
        }
        byte bL = UByteArray.l(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bL = ((UByte) operation.invoke(UByte.a(bL), UByte.a(UByteArray.l(bArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UByte.a(bL);
    }

    /* JADX INFO: renamed from: reduceOrNull-WyvcNBI, reason: not valid java name */
    private static final UInt m2005reduceOrNullWyvcNBI(int[] iArr, Function2<? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reduceOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.q(iArr)) {
            return null;
        }
        int iL = UIntArray.l(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iL = ((UInt) operation.invoke(UInt.a(iL), UInt.a(UIntArray.l(iArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UInt.a(iL);
    }

    /* JADX INFO: renamed from: reduceOrNull-s8dVfGU, reason: not valid java name */
    private static final ULong m2006reduceOrNulls8dVfGU(long[] jArr, Function2<? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reduceOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.q(jArr)) {
            return null;
        }
        long jL = ULongArray.l(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jL = ((ULong) operation.invoke(ULong.a(jL), ULong.a(ULongArray.l(jArr, i3)))).g();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return ULong.a(jL);
    }

    /* JADX INFO: renamed from: reduceOrNull-xzaTVY8, reason: not valid java name */
    private static final UShort m2007reduceOrNullxzaTVY8(short[] sArr, Function2<? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reduceOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.q(sArr)) {
            return null;
        }
        short sL = UShortArray.l(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sL = ((UShort) operation.invoke(UShort.a(sL), UShort.a(UShortArray.l(sArr, i3)))).f();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UShort.a(sL);
    }

    /* JADX INFO: renamed from: reduceRight-ELGow60, reason: not valid java name */
    private static final byte m2008reduceRightELGow60(byte[] bArr, Function2<? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reduceRight$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(bArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bL = UByteArray.l(bArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            bL = ((UByte) operation.invoke(UByte.a(UByteArray.l(bArr, i3)), UByte.a(bL))).f();
        }
        return bL;
    }

    /* JADX INFO: renamed from: reduceRight-WyvcNBI, reason: not valid java name */
    private static final int m2009reduceRightWyvcNBI(int[] iArr, Function2<? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reduceRight$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iL = UIntArray.l(iArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            iL = ((UInt) operation.invoke(UInt.a(UIntArray.l(iArr, i3)), UInt.a(iL))).f();
        }
        return iL;
    }

    /* JADX INFO: renamed from: reduceRight-s8dVfGU, reason: not valid java name */
    private static final long m2010reduceRights8dVfGU(long[] jArr, Function2<? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reduceRight$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(jArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jL = ULongArray.l(jArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            jL = ((ULong) operation.invoke(ULong.a(ULongArray.l(jArr, i3)), ULong.a(jL))).g();
        }
        return jL;
    }

    /* JADX INFO: renamed from: reduceRight-xzaTVY8, reason: not valid java name */
    private static final short m2011reduceRightxzaTVY8(short[] sArr, Function2<? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reduceRight$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(sArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sL = UShortArray.l(sArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            sL = ((UShort) operation.invoke(UShort.a(UShortArray.l(sArr, i3)), UShort.a(sL))).f();
        }
        return sL;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-D40WMg8, reason: not valid java name */
    private static final int m2012reduceRightIndexedD40WMg8(int[] iArr, Function3<? super Integer, ? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reduceRightIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iL = UIntArray.l(iArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            iL = ((UInt) operation.invoke(Integer.valueOf(i3), UInt.a(UIntArray.l(iArr, i3)), UInt.a(iL))).f();
        }
        return iL;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-EOyYB1Y, reason: not valid java name */
    private static final byte m2013reduceRightIndexedEOyYB1Y(byte[] bArr, Function3<? super Integer, ? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reduceRightIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(bArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bL = UByteArray.l(bArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            bL = ((UByte) operation.invoke(Integer.valueOf(i3), UByte.a(UByteArray.l(bArr, i3)), UByte.a(bL))).f();
        }
        return bL;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-aLgx1Fo, reason: not valid java name */
    private static final short m2014reduceRightIndexedaLgx1Fo(short[] sArr, Function3<? super Integer, ? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reduceRightIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(sArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sL = UShortArray.l(sArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            sL = ((UShort) operation.invoke(Integer.valueOf(i3), UShort.a(UShortArray.l(sArr, i3)), UShort.a(sL))).f();
        }
        return sL;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-z1zDJgo, reason: not valid java name */
    private static final long m2015reduceRightIndexedz1zDJgo(long[] jArr, Function3<? super Integer, ? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reduceRightIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(jArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jL = ULongArray.l(jArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            jL = ((ULong) operation.invoke(Integer.valueOf(i3), ULong.a(ULongArray.l(jArr, i3)), ULong.a(jL))).g();
        }
        return jL;
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-D40WMg8, reason: not valid java name */
    private static final UInt m2016reduceRightIndexedOrNullD40WMg8(int[] iArr, Function3<? super Integer, ? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reduceRightIndexedOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int iL = UIntArray.l(iArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            iL = ((UInt) operation.invoke(Integer.valueOf(i3), UInt.a(UIntArray.l(iArr, i3)), UInt.a(iL))).f();
        }
        return UInt.a(iL);
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-EOyYB1Y, reason: not valid java name */
    private static final UByte m2017reduceRightIndexedOrNullEOyYB1Y(byte[] bArr, Function3<? super Integer, ? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reduceRightIndexedOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte bL = UByteArray.l(bArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            bL = ((UByte) operation.invoke(Integer.valueOf(i3), UByte.a(UByteArray.l(bArr, i3)), UByte.a(bL))).f();
        }
        return UByte.a(bL);
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-aLgx1Fo, reason: not valid java name */
    private static final UShort m2018reduceRightIndexedOrNullaLgx1Fo(short[] sArr, Function3<? super Integer, ? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reduceRightIndexedOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short sL = UShortArray.l(sArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            sL = ((UShort) operation.invoke(Integer.valueOf(i3), UShort.a(UShortArray.l(sArr, i3)), UShort.a(sL))).f();
        }
        return UShort.a(sL);
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-z1zDJgo, reason: not valid java name */
    private static final ULong m2019reduceRightIndexedOrNullz1zDJgo(long[] jArr, Function3<? super Integer, ? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reduceRightIndexedOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long jL = ULongArray.l(jArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            jL = ((ULong) operation.invoke(Integer.valueOf(i3), ULong.a(ULongArray.l(jArr, i3)), ULong.a(jL))).g();
        }
        return ULong.a(jL);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-ELGow60, reason: not valid java name */
    private static final UByte m2020reduceRightOrNullELGow60(byte[] bArr, Function2<? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reduceRightOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte bL = UByteArray.l(bArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            bL = ((UByte) operation.invoke(UByte.a(UByteArray.l(bArr, i3)), UByte.a(bL))).f();
        }
        return UByte.a(bL);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-WyvcNBI, reason: not valid java name */
    private static final UInt m2021reduceRightOrNullWyvcNBI(int[] iArr, Function2<? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reduceRightOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int iL = UIntArray.l(iArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            iL = ((UInt) operation.invoke(UInt.a(UIntArray.l(iArr, i3)), UInt.a(iL))).f();
        }
        return UInt.a(iL);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-s8dVfGU, reason: not valid java name */
    private static final ULong m2022reduceRightOrNulls8dVfGU(long[] jArr, Function2<? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reduceRightOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long jL = ULongArray.l(jArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            jL = ((ULong) operation.invoke(ULong.a(ULongArray.l(jArr, i3)), ULong.a(jL))).g();
        }
        return ULong.a(jL);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-xzaTVY8, reason: not valid java name */
    private static final UShort m2023reduceRightOrNullxzaTVY8(short[] sArr, Function2<? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reduceRightOrNull$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = ArraysKt.getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short sL = UShortArray.l(sArr, lastIndex);
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            sL = ((UShort) operation.invoke(UShort.a(UShortArray.l(sArr, i3)), UShort.a(sL))).f();
        }
        return UShort.a(sL);
    }

    /* JADX INFO: renamed from: reverse--ajY-9A, reason: not valid java name */
    private static final void m2024reverseajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reverse$0");
        ArraysKt.reverse(iArr);
    }

    /* JADX INFO: renamed from: reverse--nroSd4, reason: not valid java name */
    private static final void m2025reversenroSd4(long[] jArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reverse$0");
        ArraysKt.reverse(jArr, i3, i4);
    }

    /* JADX INFO: renamed from: reverse-4UcCI2c, reason: not valid java name */
    private static final void m2026reverse4UcCI2c(byte[] bArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reverse$0");
        ArraysKt.reverse(bArr, i3, i4);
    }

    /* JADX INFO: renamed from: reverse-Aa5vz7o, reason: not valid java name */
    private static final void m2027reverseAa5vz7o(short[] sArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reverse$0");
        ArraysKt.reverse(sArr, i3, i4);
    }

    /* JADX INFO: renamed from: reverse-GBYM_sE, reason: not valid java name */
    private static final void m2028reverseGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reverse$0");
        ArraysKt.reverse(bArr);
    }

    /* JADX INFO: renamed from: reverse-QwZRm1k, reason: not valid java name */
    private static final void m2029reverseQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reverse$0");
        ArraysKt.reverse(jArr);
    }

    /* JADX INFO: renamed from: reverse-oBK06Vg, reason: not valid java name */
    private static final void m2030reverseoBK06Vg(int[] iArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reverse$0");
        ArraysKt.reverse(iArr, i3, i4);
    }

    /* JADX INFO: renamed from: reverse-rL5Bavg, reason: not valid java name */
    private static final void m2031reverserL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reverse$0");
        ArraysKt.reverse(sArr);
    }

    /* JADX INFO: renamed from: reversed--ajY-9A, reason: not valid java name */
    public static final List<UInt> m2032reversedajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reversed$0");
        if (UIntArray.q(iArr)) {
            return CollectionsKt.emptyList();
        }
        List<UInt> mutableList = CollectionsKt.toMutableList((Collection) UIntArray.a(iArr));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m2033reversedGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reversed$0");
        if (UByteArray.q(bArr)) {
            return CollectionsKt.emptyList();
        }
        List<UByte> mutableList = CollectionsKt.toMutableList((Collection) UByteArray.a(bArr));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m2034reversedQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reversed$0");
        if (ULongArray.q(jArr)) {
            return CollectionsKt.emptyList();
        }
        List<ULong> mutableList = CollectionsKt.toMutableList((Collection) ULongArray.a(jArr));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m2035reversedrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reversed$0");
        if (UShortArray.q(sArr)) {
            return CollectionsKt.emptyList();
        }
        List<UShort> mutableList = CollectionsKt.toMutableList((Collection) UShortArray.a(sArr));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversedArray--ajY-9A, reason: not valid java name */
    private static final int[] m2036reversedArrayajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$reversedArray$0");
        return UIntArray.d(ArraysKt.reversedArray(iArr));
    }

    /* JADX INFO: renamed from: reversedArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m2037reversedArrayGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$reversedArray$0");
        return UByteArray.d(ArraysKt.reversedArray(bArr));
    }

    /* JADX INFO: renamed from: reversedArray-QwZRm1k, reason: not valid java name */
    private static final long[] m2038reversedArrayQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$reversedArray$0");
        return ULongArray.d(ArraysKt.reversedArray(jArr));
    }

    /* JADX INFO: renamed from: reversedArray-rL5Bavg, reason: not valid java name */
    private static final short[] m2039reversedArrayrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$reversedArray$0");
        return UShortArray.d(ArraysKt.reversedArray(sArr));
    }

    /* JADX INFO: renamed from: runningFold-A8wKCXQ, reason: not valid java name */
    private static final <R> List<R> m2040runningFoldA8wKCXQ(long[] jArr, R r2, Function2<? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$runningFold$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.q(jArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(ULongArray.o(jArr) + 1);
        arrayList.add(r2);
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, ULong.a(ULongArray.l(jArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFold-yXmHNn8, reason: not valid java name */
    private static final <R> List<R> m2041runningFoldyXmHNn8(byte[] bArr, R r2, Function2<? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$runningFold$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.q(bArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UByteArray.o(bArr) + 1);
        arrayList.add(r2);
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, UByte.a(UByteArray.l(bArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFold-zi1B2BA, reason: not valid java name */
    private static final <R> List<R> m2042runningFoldzi1B2BA(int[] iArr, R r2, Function2<? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$runningFold$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.q(iArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UIntArray.o(iArr) + 1);
        arrayList.add(r2);
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, UInt.a(UIntArray.l(iArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFold-zww5nb8, reason: not valid java name */
    private static final <R> List<R> m2043runningFoldzww5nb8(short[] sArr, R r2, Function2<? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$runningFold$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.q(sArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UShortArray.o(sArr) + 1);
        arrayList.add(r2);
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, UShort.a(UShortArray.l(sArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> List<R> m2044runningFoldIndexed3iWJZGE(byte[] bArr, R r2, Function3<? super Integer, ? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$runningFoldIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.q(bArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UByteArray.o(bArr) + 1);
        arrayList.add(r2);
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, UByte.a(UByteArray.l(bArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-bzxtMww, reason: not valid java name */
    private static final <R> List<R> m2045runningFoldIndexedbzxtMww(short[] sArr, R r2, Function3<? super Integer, ? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$runningFoldIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.q(sArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UShortArray.o(sArr) + 1);
        arrayList.add(r2);
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, UShort.a(UShortArray.l(sArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> List<R> m2046runningFoldIndexedmwnnOCs(long[] jArr, R r2, Function3<? super Integer, ? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$runningFoldIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.q(jArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(ULongArray.o(jArr) + 1);
        arrayList.add(r2);
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, ULong.a(ULongArray.l(jArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> List<R> m2047runningFoldIndexedyVwIW0Q(int[] iArr, R r2, Function3<? super Integer, ? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$runningFoldIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.q(iArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UIntArray.o(iArr) + 1);
        arrayList.add(r2);
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, UInt.a(UIntArray.l(iArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-ELGow60, reason: not valid java name */
    private static final List<UByte> m2048runningReduceELGow60(byte[] bArr, Function2<? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$runningReduce$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.q(bArr)) {
            return CollectionsKt.emptyList();
        }
        byte bL = UByteArray.l(bArr, 0);
        ArrayList arrayList = new ArrayList(UByteArray.o(bArr));
        arrayList.add(UByte.a(bL));
        int iO = UByteArray.o(bArr);
        for (int i3 = 1; i3 < iO; i3++) {
            bL = ((UByte) operation.invoke(UByte.a(bL), UByte.a(UByteArray.l(bArr, i3)))).f();
            arrayList.add(UByte.a(bL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-WyvcNBI, reason: not valid java name */
    private static final List<UInt> m2049runningReduceWyvcNBI(int[] iArr, Function2<? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$runningReduce$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.q(iArr)) {
            return CollectionsKt.emptyList();
        }
        int iL = UIntArray.l(iArr, 0);
        ArrayList arrayList = new ArrayList(UIntArray.o(iArr));
        arrayList.add(UInt.a(iL));
        int iO = UIntArray.o(iArr);
        for (int i3 = 1; i3 < iO; i3++) {
            iL = ((UInt) operation.invoke(UInt.a(iL), UInt.a(UIntArray.l(iArr, i3)))).f();
            arrayList.add(UInt.a(iL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-s8dVfGU, reason: not valid java name */
    private static final List<ULong> m2050runningReduces8dVfGU(long[] jArr, Function2<? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$runningReduce$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.q(jArr)) {
            return CollectionsKt.emptyList();
        }
        long jL = ULongArray.l(jArr, 0);
        ArrayList arrayList = new ArrayList(ULongArray.o(jArr));
        arrayList.add(ULong.a(jL));
        int iO = ULongArray.o(jArr);
        for (int i3 = 1; i3 < iO; i3++) {
            jL = ((ULong) operation.invoke(ULong.a(jL), ULong.a(ULongArray.l(jArr, i3)))).g();
            arrayList.add(ULong.a(jL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-xzaTVY8, reason: not valid java name */
    private static final List<UShort> m2051runningReducexzaTVY8(short[] sArr, Function2<? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$runningReduce$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.q(sArr)) {
            return CollectionsKt.emptyList();
        }
        short sL = UShortArray.l(sArr, 0);
        ArrayList arrayList = new ArrayList(UShortArray.o(sArr));
        arrayList.add(UShort.a(sL));
        int iO = UShortArray.o(sArr);
        for (int i3 = 1; i3 < iO; i3++) {
            sL = ((UShort) operation.invoke(UShort.a(sL), UShort.a(UShortArray.l(sArr, i3)))).f();
            arrayList.add(UShort.a(sL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-D40WMg8, reason: not valid java name */
    private static final List<UInt> m2052runningReduceIndexedD40WMg8(int[] iArr, Function3<? super Integer, ? super UInt, ? super UInt, UInt> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$runningReduceIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.q(iArr)) {
            return CollectionsKt.emptyList();
        }
        int iL = UIntArray.l(iArr, 0);
        ArrayList arrayList = new ArrayList(UIntArray.o(iArr));
        arrayList.add(UInt.a(iL));
        int iO = UIntArray.o(iArr);
        for (int i3 = 1; i3 < iO; i3++) {
            iL = ((UInt) operation.invoke(Integer.valueOf(i3), UInt.a(iL), UInt.a(UIntArray.l(iArr, i3)))).f();
            arrayList.add(UInt.a(iL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-EOyYB1Y, reason: not valid java name */
    private static final List<UByte> m2053runningReduceIndexedEOyYB1Y(byte[] bArr, Function3<? super Integer, ? super UByte, ? super UByte, UByte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$runningReduceIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.q(bArr)) {
            return CollectionsKt.emptyList();
        }
        byte bL = UByteArray.l(bArr, 0);
        ArrayList arrayList = new ArrayList(UByteArray.o(bArr));
        arrayList.add(UByte.a(bL));
        int iO = UByteArray.o(bArr);
        for (int i3 = 1; i3 < iO; i3++) {
            bL = ((UByte) operation.invoke(Integer.valueOf(i3), UByte.a(bL), UByte.a(UByteArray.l(bArr, i3)))).f();
            arrayList.add(UByte.a(bL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-aLgx1Fo, reason: not valid java name */
    private static final List<UShort> m2054runningReduceIndexedaLgx1Fo(short[] sArr, Function3<? super Integer, ? super UShort, ? super UShort, UShort> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$runningReduceIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.q(sArr)) {
            return CollectionsKt.emptyList();
        }
        short sL = UShortArray.l(sArr, 0);
        ArrayList arrayList = new ArrayList(UShortArray.o(sArr));
        arrayList.add(UShort.a(sL));
        int iO = UShortArray.o(sArr);
        for (int i3 = 1; i3 < iO; i3++) {
            sL = ((UShort) operation.invoke(Integer.valueOf(i3), UShort.a(sL), UShort.a(UShortArray.l(sArr, i3)))).f();
            arrayList.add(UShort.a(sL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-z1zDJgo, reason: not valid java name */
    private static final List<ULong> m2055runningReduceIndexedz1zDJgo(long[] jArr, Function3<? super Integer, ? super ULong, ? super ULong, ULong> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$runningReduceIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.q(jArr)) {
            return CollectionsKt.emptyList();
        }
        long jL = ULongArray.l(jArr, 0);
        ArrayList arrayList = new ArrayList(ULongArray.o(jArr));
        arrayList.add(ULong.a(jL));
        int iO = ULongArray.o(jArr);
        for (int i3 = 1; i3 < iO; i3++) {
            jL = ((ULong) operation.invoke(Integer.valueOf(i3), ULong.a(jL), ULong.a(ULongArray.l(jArr, i3)))).g();
            arrayList.add(ULong.a(jL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-A8wKCXQ, reason: not valid java name */
    private static final <R> List<R> m2056scanA8wKCXQ(long[] jArr, R r2, Function2<? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$scan$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.q(jArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(ULongArray.o(jArr) + 1);
        arrayList.add(r2);
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, ULong.a(ULongArray.l(jArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-yXmHNn8, reason: not valid java name */
    private static final <R> List<R> m2057scanyXmHNn8(byte[] bArr, R r2, Function2<? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$scan$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.q(bArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UByteArray.o(bArr) + 1);
        arrayList.add(r2);
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, UByte.a(UByteArray.l(bArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-zi1B2BA, reason: not valid java name */
    private static final <R> List<R> m2058scanzi1B2BA(int[] iArr, R r2, Function2<? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$scan$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.q(iArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UIntArray.o(iArr) + 1);
        arrayList.add(r2);
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, UInt.a(UIntArray.l(iArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-zww5nb8, reason: not valid java name */
    private static final <R> List<R> m2059scanzww5nb8(short[] sArr, R r2, Function2<? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$scan$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.q(sArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UShortArray.o(sArr) + 1);
        arrayList.add(r2);
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(r2, UShort.a(UShortArray.l(sArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> List<R> m2060scanIndexed3iWJZGE(byte[] bArr, R r2, Function3<? super Integer, ? super R, ? super UByte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$scanIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UByteArray.q(bArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UByteArray.o(bArr) + 1);
        arrayList.add(r2);
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, UByte.a(UByteArray.l(bArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-bzxtMww, reason: not valid java name */
    private static final <R> List<R> m2061scanIndexedbzxtMww(short[] sArr, R r2, Function3<? super Integer, ? super R, ? super UShort, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$scanIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UShortArray.q(sArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UShortArray.o(sArr) + 1);
        arrayList.add(r2);
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, UShort.a(UShortArray.l(sArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> List<R> m2062scanIndexedmwnnOCs(long[] jArr, R r2, Function3<? super Integer, ? super R, ? super ULong, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$scanIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (ULongArray.q(jArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(ULongArray.o(jArr) + 1);
        arrayList.add(r2);
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, ULong.a(ULongArray.l(jArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> List<R> m2063scanIndexedyVwIW0Q(int[] iArr, R r2, Function3<? super Integer, ? super R, ? super UInt, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$scanIndexed$0");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (UIntArray.q(iArr)) {
            return CollectionsKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(UIntArray.o(iArr) + 1);
        arrayList.add(r2);
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, UInt.a(UIntArray.l(iArr, i3)));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: shuffle--ajY-9A, reason: not valid java name */
    public static final void m2064shuffleajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$shuffle$0");
        m2065shuffle2D5oskM(iArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: shuffle-2D5oskM, reason: not valid java name */
    public static final void m2065shuffle2D5oskM(int[] iArr, Random random) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$shuffle$0");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(iArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            int iL = UIntArray.l(iArr, lastIndex);
            UIntArray.t(iArr, lastIndex, UIntArray.l(iArr, iJ));
            UIntArray.t(iArr, iJ, iL);
        }
    }

    /* JADX INFO: renamed from: shuffle-GBYM_sE, reason: not valid java name */
    public static final void m2066shuffleGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$shuffle$0");
        m2069shuffleoSF2wD8(bArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: shuffle-JzugnMA, reason: not valid java name */
    public static final void m2067shuffleJzugnMA(long[] jArr, Random random) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$shuffle$0");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(jArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            long jL = ULongArray.l(jArr, lastIndex);
            ULongArray.t(jArr, lastIndex, ULongArray.l(jArr, iJ));
            ULongArray.t(jArr, iJ, jL);
        }
    }

    /* JADX INFO: renamed from: shuffle-QwZRm1k, reason: not valid java name */
    public static final void m2068shuffleQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$shuffle$0");
        m2067shuffleJzugnMA(jArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: shuffle-oSF2wD8, reason: not valid java name */
    public static final void m2069shuffleoSF2wD8(byte[] bArr, Random random) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$shuffle$0");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(bArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            byte bL = UByteArray.l(bArr, lastIndex);
            UByteArray.t(bArr, lastIndex, UByteArray.l(bArr, iJ));
            UByteArray.t(bArr, iJ, bL);
        }
    }

    /* JADX INFO: renamed from: shuffle-rL5Bavg, reason: not valid java name */
    public static final void m2070shufflerL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$shuffle$0");
        m2071shuffles5X_as8(sArr, Random.f140182a);
    }

    /* JADX INFO: renamed from: shuffle-s5X_as8, reason: not valid java name */
    public static final void m2071shuffles5X_as8(short[] sArr, Random random) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$shuffle$0");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(sArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            short sL = UShortArray.l(sArr, lastIndex);
            UShortArray.t(sArr, lastIndex, UShortArray.l(sArr, iJ));
            UShortArray.t(sArr, iJ, sL);
        }
    }

    /* JADX INFO: renamed from: single--ajY-9A, reason: not valid java name */
    private static final int m2072singleajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$single$0");
        return UInt.b(ArraysKt.single(iArr));
    }

    /* JADX INFO: renamed from: single-GBYM_sE, reason: not valid java name */
    private static final byte m2073singleGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$single$0");
        return UByte.b(ArraysKt.single(bArr));
    }

    /* JADX INFO: renamed from: single-JOV_ifY, reason: not valid java name */
    private static final byte m2074singleJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$single$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        UByte uByteA = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            if (((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                if (z2) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                uByteA = UByte.a(bL);
                z2 = true;
            }
        }
        if (z2) {
            return uByteA.f();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: single-MShoTSo, reason: not valid java name */
    private static final long m2075singleMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$single$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        ULong uLongA = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            if (((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                if (z2) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                uLongA = ULong.a(jL);
                z2 = true;
            }
        }
        if (z2) {
            return uLongA.g();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: single-QwZRm1k, reason: not valid java name */
    private static final long m2076singleQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$single$0");
        return ULong.b(ArraysKt.single(jArr));
    }

    /* JADX INFO: renamed from: single-jgv0xPQ, reason: not valid java name */
    private static final int m2077singlejgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$single$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        UInt uIntA = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            if (((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                if (z2) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                uIntA = UInt.a(iL);
                z2 = true;
            }
        }
        if (z2) {
            return uIntA.f();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: single-rL5Bavg, reason: not valid java name */
    private static final short m2078singlerL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$single$0");
        return UShort.b(ArraysKt.single(sArr));
    }

    /* JADX INFO: renamed from: single-xTcfx_M, reason: not valid java name */
    private static final short m2079singlexTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$single$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        UShort uShortA = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            if (((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                if (z2) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                uShortA = UShort.a(sL);
                z2 = true;
            }
        }
        if (z2) {
            return uShortA.f();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: singleOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m2080singleOrNullajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$singleOrNull$0");
        if (UIntArray.o(iArr) == 1) {
            return UInt.a(UIntArray.l(iArr, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m2081singleOrNullGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$singleOrNull$0");
        if (UByteArray.o(bArr) == 1) {
            return UByte.a(UByteArray.l(bArr, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-JOV_ifY, reason: not valid java name */
    private static final UByte m2082singleOrNullJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$singleOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UByteArray.o(bArr);
        UByte uByteA = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            if (((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                if (z2) {
                    return null;
                }
                uByteA = UByte.a(bL);
                z2 = true;
            }
        }
        if (z2) {
            return uByteA;
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-MShoTSo, reason: not valid java name */
    private static final ULong m2083singleOrNullMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$singleOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = ULongArray.o(jArr);
        ULong uLongA = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            if (((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                if (z2) {
                    return null;
                }
                uLongA = ULong.a(jL);
                z2 = true;
            }
        }
        if (z2) {
            return uLongA;
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m2084singleOrNullQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$singleOrNull$0");
        if (ULongArray.o(jArr) == 1) {
            return ULong.a(ULongArray.l(jArr, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-jgv0xPQ, reason: not valid java name */
    private static final UInt m2085singleOrNulljgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$singleOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UIntArray.o(iArr);
        UInt uIntA = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            if (((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                if (z2) {
                    return null;
                }
                uIntA = UInt.a(iL);
                z2 = true;
            }
        }
        if (z2) {
            return uIntA;
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m2086singleOrNullrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$singleOrNull$0");
        if (UShortArray.o(sArr) == 1) {
            return UShort.a(UShortArray.l(sArr, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-xTcfx_M, reason: not valid java name */
    private static final UShort m2087singleOrNullxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$singleOrNull$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        UShort uShortA = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            if (((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                if (z2) {
                    return null;
                }
                uShortA = UShort.a(sL);
                z2 = true;
            }
        }
        if (z2) {
            return uShortA;
        }
        return null;
    }

    /* JADX INFO: renamed from: slice-F7u83W8, reason: not valid java name */
    public static final List<ULong> m2088sliceF7u83W8(long[] jArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$slice$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(ULong.a(ULongArray.l(jArr, it.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-HwE9HBo, reason: not valid java name */
    public static final List<UInt> m2089sliceHwE9HBo(int[] iArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$slice$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UInt.a(UIntArray.l(iArr, it.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-JGPC0-M, reason: not valid java name */
    public static final List<UShort> m2090sliceJGPC0M(short[] sArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$slice$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UShort.a(UShortArray.l(sArr, it.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-JQknh5Q, reason: not valid java name */
    public static final List<UByte> m2091sliceJQknh5Q(byte[] bArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$slice$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UByte.a(UByteArray.l(bArr, it.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-Q6IL4kU, reason: not valid java name */
    public static final List<UShort> m2092sliceQ6IL4kU(short[] sArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$slice$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m1491asListrL5Bavg(UShortArray.d(ArraysKt.copyOfRange(sArr, indices.a().intValue(), indices.e().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-ZRhS8yI, reason: not valid java name */
    public static final List<ULong> m2093sliceZRhS8yI(long[] jArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$slice$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m1490asListQwZRm1k(ULongArray.d(ArraysKt.copyOfRange(jArr, indices.a().intValue(), indices.e().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-c0bezYM, reason: not valid java name */
    public static final List<UByte> m2094slicec0bezYM(byte[] bArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$slice$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m1489asListGBYM_sE(UByteArray.d(ArraysKt.copyOfRange(bArr, indices.a().intValue(), indices.e().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-tAntMlw, reason: not valid java name */
    public static final List<UInt> m2095slicetAntMlw(int[] iArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$slice$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m1488asListajY9A(UIntArray.d(ArraysKt.copyOfRange(iArr, indices.a().intValue(), indices.e().intValue() + 1)));
    }

    /* JADX INFO: renamed from: sliceArray-CFIt9YE, reason: not valid java name */
    public static final int[] m2096sliceArrayCFIt9YE(int[] iArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sliceArray$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UIntArray.d(ArraysKt.sliceArray(iArr, indices));
    }

    /* JADX INFO: renamed from: sliceArray-Q6IL4kU, reason: not valid java name */
    public static final short[] m2097sliceArrayQ6IL4kU(short[] sArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sliceArray$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UShortArray.d(ArraysKt.sliceArray(sArr, indices));
    }

    /* JADX INFO: renamed from: sliceArray-ZRhS8yI, reason: not valid java name */
    public static final long[] m2098sliceArrayZRhS8yI(long[] jArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sliceArray$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return ULongArray.d(ArraysKt.sliceArray(jArr, indices));
    }

    /* JADX INFO: renamed from: sliceArray-c0bezYM, reason: not valid java name */
    public static final byte[] m2099sliceArrayc0bezYM(byte[] bArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sliceArray$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UByteArray.d(ArraysKt.sliceArray(bArr, indices));
    }

    /* JADX INFO: renamed from: sliceArray-kzHmqpY, reason: not valid java name */
    public static final long[] m2100sliceArraykzHmqpY(long[] jArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sliceArray$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return ULongArray.d(ArraysKt.sliceArray(jArr, indices));
    }

    /* JADX INFO: renamed from: sliceArray-ojwP5H8, reason: not valid java name */
    public static final short[] m2101sliceArrayojwP5H8(short[] sArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sliceArray$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UShortArray.d(ArraysKt.sliceArray(sArr, indices));
    }

    /* JADX INFO: renamed from: sliceArray-tAntMlw, reason: not valid java name */
    public static final int[] m2102sliceArraytAntMlw(int[] iArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sliceArray$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UIntArray.d(ArraysKt.sliceArray(iArr, indices));
    }

    /* JADX INFO: renamed from: sliceArray-xo_DsdI, reason: not valid java name */
    public static final byte[] m2103sliceArrayxo_DsdI(byte[] bArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sliceArray$0");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UByteArray.d(ArraysKt.sliceArray(bArr, indices));
    }

    /* JADX INFO: renamed from: sort--ajY-9A, reason: not valid java name */
    public static final void m2104sortajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sort$0");
        if (UIntArray.o(iArr) > 1) {
            UArraySortingKt.m1486sortArrayoBK06Vg(iArr, 0, UIntArray.o(iArr));
        }
    }

    /* JADX INFO: renamed from: sort--nroSd4, reason: not valid java name */
    public static final void m2105sortnroSd4(long[] jArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sort$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, ULongArray.o(jArr));
        if (i3 < i4 - 1) {
            UArraySortingKt.m1483sortArraynroSd4(jArr, i3, i4);
        }
    }

    /* JADX INFO: renamed from: sort--nroSd4$default, reason: not valid java name */
    public static /* synthetic */ void m2106sortnroSd4$default(long[] jArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = ULongArray.o(jArr);
        }
        m2105sortnroSd4(jArr, i3, i4);
    }

    /* JADX INFO: renamed from: sort-4UcCI2c, reason: not valid java name */
    public static final void m2107sort4UcCI2c(byte[] bArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sort$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, UByteArray.o(bArr));
        if (i3 < i4 - 1) {
            UArraySortingKt.m1484sortArray4UcCI2c(bArr, i3, i4);
        }
    }

    /* JADX INFO: renamed from: sort-4UcCI2c$default, reason: not valid java name */
    public static /* synthetic */ void m2108sort4UcCI2c$default(byte[] bArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = UByteArray.o(bArr);
        }
        m2107sort4UcCI2c(bArr, i3, i4);
    }

    /* JADX INFO: renamed from: sort-Aa5vz7o, reason: not valid java name */
    public static final void m2109sortAa5vz7o(short[] sArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sort$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, UShortArray.o(sArr));
        if (i3 < i4 - 1) {
            UArraySortingKt.m1485sortArrayAa5vz7o(sArr, i3, i4);
        }
    }

    /* JADX INFO: renamed from: sort-Aa5vz7o$default, reason: not valid java name */
    public static /* synthetic */ void m2110sortAa5vz7o$default(short[] sArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = UShortArray.o(sArr);
        }
        m2109sortAa5vz7o(sArr, i3, i4);
    }

    /* JADX INFO: renamed from: sort-GBYM_sE, reason: not valid java name */
    public static final void m2111sortGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sort$0");
        if (UByteArray.o(bArr) > 1) {
            UArraySortingKt.m1484sortArray4UcCI2c(bArr, 0, UByteArray.o(bArr));
        }
    }

    /* JADX INFO: renamed from: sort-QwZRm1k, reason: not valid java name */
    public static final void m2112sortQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sort$0");
        if (ULongArray.o(jArr) > 1) {
            UArraySortingKt.m1483sortArraynroSd4(jArr, 0, ULongArray.o(jArr));
        }
    }

    /* JADX INFO: renamed from: sort-oBK06Vg, reason: not valid java name */
    public static final void m2113sortoBK06Vg(int[] iArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sort$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, UIntArray.o(iArr));
        if (i3 < i4 - 1) {
            UArraySortingKt.m1486sortArrayoBK06Vg(iArr, i3, i4);
        }
    }

    /* JADX INFO: renamed from: sort-oBK06Vg$default, reason: not valid java name */
    public static /* synthetic */ void m2114sortoBK06Vg$default(int[] iArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = UIntArray.o(iArr);
        }
        m2113sortoBK06Vg(iArr, i3, i4);
    }

    /* JADX INFO: renamed from: sort-rL5Bavg, reason: not valid java name */
    public static final void m2115sortrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sort$0");
        if (UShortArray.o(sArr) > 1) {
            UArraySortingKt.m1485sortArrayAa5vz7o(sArr, 0, UShortArray.o(sArr));
        }
    }

    /* JADX INFO: renamed from: sortDescending--ajY-9A, reason: not valid java name */
    public static final void m2116sortDescendingajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sortDescending$0");
        if (UIntArray.o(iArr) > 1) {
            m2104sortajY9A(iArr);
            ArraysKt.reverse(iArr);
        }
    }

    /* JADX INFO: renamed from: sortDescending--nroSd4, reason: not valid java name */
    public static final void m2117sortDescendingnroSd4(long[] jArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sortDescending$0");
        m2105sortnroSd4(jArr, i3, i4);
        ArraysKt.reverse(jArr, i3, i4);
    }

    /* JADX INFO: renamed from: sortDescending-4UcCI2c, reason: not valid java name */
    public static final void m2118sortDescending4UcCI2c(byte[] bArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sortDescending$0");
        m2107sort4UcCI2c(bArr, i3, i4);
        ArraysKt.reverse(bArr, i3, i4);
    }

    /* JADX INFO: renamed from: sortDescending-Aa5vz7o, reason: not valid java name */
    public static final void m2119sortDescendingAa5vz7o(short[] sArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sortDescending$0");
        m2109sortAa5vz7o(sArr, i3, i4);
        ArraysKt.reverse(sArr, i3, i4);
    }

    /* JADX INFO: renamed from: sortDescending-GBYM_sE, reason: not valid java name */
    public static final void m2120sortDescendingGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sortDescending$0");
        if (UByteArray.o(bArr) > 1) {
            m2111sortGBYM_sE(bArr);
            ArraysKt.reverse(bArr);
        }
    }

    /* JADX INFO: renamed from: sortDescending-QwZRm1k, reason: not valid java name */
    public static final void m2121sortDescendingQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sortDescending$0");
        if (ULongArray.o(jArr) > 1) {
            m2112sortQwZRm1k(jArr);
            ArraysKt.reverse(jArr);
        }
    }

    /* JADX INFO: renamed from: sortDescending-oBK06Vg, reason: not valid java name */
    public static final void m2122sortDescendingoBK06Vg(int[] iArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sortDescending$0");
        m2113sortoBK06Vg(iArr, i3, i4);
        ArraysKt.reverse(iArr, i3, i4);
    }

    /* JADX INFO: renamed from: sortDescending-rL5Bavg, reason: not valid java name */
    public static final void m2123sortDescendingrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sortDescending$0");
        if (UShortArray.o(sArr) > 1) {
            m2115sortrL5Bavg(sArr);
            ArraysKt.reverse(sArr);
        }
    }

    /* JADX INFO: renamed from: sorted--ajY-9A, reason: not valid java name */
    public static final List<UInt> m2124sortedajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sorted$0");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrD = UIntArray.d(iArrCopyOf);
        m2104sortajY9A(iArrD);
        return UArraysKt___UArraysJvmKt.m1488asListajY9A(iArrD);
    }

    /* JADX INFO: renamed from: sorted-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m2125sortedGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sorted$0");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrD = UByteArray.d(bArrCopyOf);
        m2111sortGBYM_sE(bArrD);
        return UArraysKt___UArraysJvmKt.m1489asListGBYM_sE(bArrD);
    }

    /* JADX INFO: renamed from: sorted-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m2126sortedQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sorted$0");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrD = ULongArray.d(jArrCopyOf);
        m2112sortQwZRm1k(jArrD);
        return UArraysKt___UArraysJvmKt.m1490asListQwZRm1k(jArrD);
    }

    /* JADX INFO: renamed from: sorted-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m2127sortedrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sorted$0");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrD = UShortArray.d(sArrCopyOf);
        m2115sortrL5Bavg(sArrD);
        return UArraysKt___UArraysJvmKt.m1491asListrL5Bavg(sArrD);
    }

    /* JADX INFO: renamed from: sortedArray--ajY-9A, reason: not valid java name */
    public static final int[] m2128sortedArrayajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sortedArray$0");
        if (UIntArray.q(iArr)) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrD = UIntArray.d(iArrCopyOf);
        m2104sortajY9A(iArrD);
        return iArrD;
    }

    /* JADX INFO: renamed from: sortedArray-GBYM_sE, reason: not valid java name */
    public static final byte[] m2129sortedArrayGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sortedArray$0");
        if (UByteArray.q(bArr)) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrD = UByteArray.d(bArrCopyOf);
        m2111sortGBYM_sE(bArrD);
        return bArrD;
    }

    /* JADX INFO: renamed from: sortedArray-rL5Bavg, reason: not valid java name */
    public static final short[] m2131sortedArrayrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sortedArray$0");
        if (UShortArray.q(sArr)) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrD = UShortArray.d(sArrCopyOf);
        m2115sortrL5Bavg(sArrD);
        return sArrD;
    }

    /* JADX INFO: renamed from: sortedArrayDescending--ajY-9A, reason: not valid java name */
    public static final int[] m2132sortedArrayDescendingajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sortedArrayDescending$0");
        if (UIntArray.q(iArr)) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrD = UIntArray.d(iArrCopyOf);
        m2116sortDescendingajY9A(iArrD);
        return iArrD;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-GBYM_sE, reason: not valid java name */
    public static final byte[] m2133sortedArrayDescendingGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sortedArrayDescending$0");
        if (UByteArray.q(bArr)) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrD = UByteArray.d(bArrCopyOf);
        m2120sortDescendingGBYM_sE(bArrD);
        return bArrD;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-QwZRm1k, reason: not valid java name */
    public static final long[] m2134sortedArrayDescendingQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sortedArrayDescending$0");
        if (ULongArray.q(jArr)) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrD = ULongArray.d(jArrCopyOf);
        m2121sortDescendingQwZRm1k(jArrD);
        return jArrD;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-rL5Bavg, reason: not valid java name */
    public static final short[] m2135sortedArrayDescendingrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sortedArrayDescending$0");
        if (UShortArray.q(sArr)) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrD = UShortArray.d(sArrCopyOf);
        m2123sortDescendingrL5Bavg(sArrD);
        return sArrD;
    }

    /* JADX INFO: renamed from: sortedDescending--ajY-9A, reason: not valid java name */
    public static final List<UInt> m2136sortedDescendingajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sortedDescending$0");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrD = UIntArray.d(iArrCopyOf);
        m2104sortajY9A(iArrD);
        return m2032reversedajY9A(iArrD);
    }

    /* JADX INFO: renamed from: sortedDescending-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m2137sortedDescendingGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sortedDescending$0");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrD = UByteArray.d(bArrCopyOf);
        m2111sortGBYM_sE(bArrD);
        return m2033reversedGBYM_sE(bArrD);
    }

    /* JADX INFO: renamed from: sortedDescending-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m2138sortedDescendingQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sortedDescending$0");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrD = ULongArray.d(jArrCopyOf);
        m2112sortQwZRm1k(jArrD);
        return m2034reversedQwZRm1k(jArrD);
    }

    /* JADX INFO: renamed from: sortedDescending-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m2139sortedDescendingrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sortedDescending$0");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrD = UShortArray.d(sArrCopyOf);
        m2115sortrL5Bavg(sArrD);
        return m2035reversedrL5Bavg(sArrD);
    }

    /* JADX INFO: renamed from: sum--ajY-9A, reason: not valid java name */
    private static final int m2140sumajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sum$0");
        return UInt.b(ArraysKt.sum(iArr));
    }

    /* JADX INFO: renamed from: sum-GBYM_sE, reason: not valid java name */
    private static final int m2141sumGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sum$0");
        int iB = UInt.b(0);
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            iB = UInt.b(iB + UInt.b(UByteArray.l(bArr, i3) & 255));
        }
        return iB;
    }

    /* JADX INFO: renamed from: sum-QwZRm1k, reason: not valid java name */
    private static final long m2142sumQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sum$0");
        return ULong.b(ArraysKt.sum(jArr));
    }

    /* JADX INFO: renamed from: sum-rL5Bavg, reason: not valid java name */
    private static final int m2143sumrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sum$0");
        int iB = UInt.b(0);
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            iB = UInt.b(iB + UInt.b(UShortArray.l(sArr, i3) & 65535));
        }
        return iB;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: sumBy-JOV_ifY, reason: not valid java name */
    private static final int m2144sumByJOV_ifY(byte[] bArr, Function1<? super UByte, UInt> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sumBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UByteArray.o(bArr);
        int iB = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            iB = UInt.b(iB + ((UInt) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).f());
        }
        return iB;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: sumBy-MShoTSo, reason: not valid java name */
    private static final int m2145sumByMShoTSo(long[] jArr, Function1<? super ULong, UInt> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sumBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = ULongArray.o(jArr);
        int iB = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            iB = UInt.b(iB + ((UInt) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).f());
        }
        return iB;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: sumBy-jgv0xPQ, reason: not valid java name */
    private static final int m2146sumByjgv0xPQ(int[] iArr, Function1<? super UInt, UInt> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sumBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UIntArray.o(iArr);
        int iB = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            iB = UInt.b(iB + ((UInt) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).f());
        }
        return iB;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: sumBy-xTcfx_M, reason: not valid java name */
    private static final int m2147sumByxTcfx_M(short[] sArr, Function1<? super UShort, UInt> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sumBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UShortArray.o(sArr);
        int iB = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            iB = UInt.b(iB + ((UInt) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).f());
        }
        return iB;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: sumByDouble-JOV_ifY, reason: not valid java name */
    private static final double m2148sumByDoubleJOV_ifY(byte[] bArr, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sumByDouble$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UByteArray.o(bArr);
        double dDoubleValue = 0.0d;
        for (int i3 = 0; i3 < iO; i3++) {
            dDoubleValue += ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).doubleValue();
        }
        return dDoubleValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: sumByDouble-MShoTSo, reason: not valid java name */
    private static final double m2149sumByDoubleMShoTSo(long[] jArr, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sumByDouble$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = ULongArray.o(jArr);
        double dDoubleValue = 0.0d;
        for (int i3 = 0; i3 < iO; i3++) {
            dDoubleValue += ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).doubleValue();
        }
        return dDoubleValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: sumByDouble-jgv0xPQ, reason: not valid java name */
    private static final double m2150sumByDoublejgv0xPQ(int[] iArr, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sumByDouble$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UIntArray.o(iArr);
        double dDoubleValue = 0.0d;
        for (int i3 = 0; i3 < iO; i3++) {
            dDoubleValue += ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).doubleValue();
        }
        return dDoubleValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: sumByDouble-xTcfx_M, reason: not valid java name */
    private static final double m2151sumByDoublexTcfx_M(short[] sArr, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sumByDouble$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UShortArray.o(sArr);
        double dDoubleValue = 0.0d;
        for (int i3 = 0; i3 < iO; i3++) {
            dDoubleValue += ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(int[] iArr, Function1<? super UInt, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UIntArray.o(iArr);
        double dDoubleValue = 0.0d;
        for (int i3 = 0; i3 < iO; i3++) {
            dDoubleValue += ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(int[] iArr, Function1<? super UInt, Integer> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UIntArray.o(iArr);
        int iIntValue = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            iIntValue += ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(int[] iArr, Function1<? super UInt, Long> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UIntArray.o(iArr);
        long jLongValue = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            jLongValue += ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).longValue();
        }
        return jLongValue;
    }

    public static final int sumOfUByte(UByte[] uByteArr) {
        Intrinsics.checkNotNullParameter(uByteArr, "<this>");
        int iB = 0;
        for (UByte uByte : uByteArr) {
            iB = UInt.b(iB + UInt.b(uByte.f() & 255));
        }
        return iB;
    }

    private static final int sumOfUInt(int[] iArr, Function1<? super UInt, UInt> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            iB = UInt.b(iB + ((UInt) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).f());
        }
        return iB;
    }

    private static final long sumOfULong(int[] iArr, Function1<? super UInt, ULong> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            jB = ULong.b(jB + ((ULong) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).g());
        }
        return jB;
    }

    public static final int sumOfUShort(UShort[] uShortArr) {
        Intrinsics.checkNotNullParameter(uShortArr, "<this>");
        int iB = 0;
        for (UShort uShort : uShortArr) {
            iB = UInt.b(iB + UInt.b(uShort.f() & 65535));
        }
        return iB;
    }

    /* JADX INFO: renamed from: take-PpDY95g, reason: not valid java name */
    public static final List<UByte> m2152takePpDY95g(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$take$0");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt.emptyList();
        }
        if (i3 >= UByteArray.o(bArr)) {
            return CollectionsKt.toList(UByteArray.a(bArr));
        }
        if (i3 == 1) {
            return CollectionsKt.listOf(UByte.a(UByteArray.l(bArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i3);
        int iO = UByteArray.o(bArr);
        int i4 = 0;
        for (int i5 = 0; i5 < iO; i5++) {
            arrayList.add(UByte.a(UByteArray.l(bArr, i5)));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-nggk6HY, reason: not valid java name */
    public static final List<UShort> m2153takenggk6HY(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$take$0");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt.emptyList();
        }
        if (i3 >= UShortArray.o(sArr)) {
            return CollectionsKt.toList(UShortArray.a(sArr));
        }
        if (i3 == 1) {
            return CollectionsKt.listOf(UShort.a(UShortArray.l(sArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i3);
        int iO = UShortArray.o(sArr);
        int i4 = 0;
        for (int i5 = 0; i5 < iO; i5++) {
            arrayList.add(UShort.a(UShortArray.l(sArr, i5)));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m2154takeqFRl0hI(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$take$0");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt.emptyList();
        }
        if (i3 >= UIntArray.o(iArr)) {
            return CollectionsKt.toList(UIntArray.a(iArr));
        }
        if (i3 == 1) {
            return CollectionsKt.listOf(UInt.a(UIntArray.l(iArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i3);
        int iO = UIntArray.o(iArr);
        int i4 = 0;
        for (int i5 = 0; i5 < iO; i5++) {
            arrayList.add(UInt.a(UIntArray.l(iArr, i5)));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-r7IrZao, reason: not valid java name */
    public static final List<ULong> m2155taker7IrZao(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$take$0");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt.emptyList();
        }
        if (i3 >= ULongArray.o(jArr)) {
            return CollectionsKt.toList(ULongArray.a(jArr));
        }
        if (i3 == 1) {
            return CollectionsKt.listOf(ULong.a(ULongArray.l(jArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i3);
        int iO = ULongArray.o(jArr);
        int i4 = 0;
        for (int i5 = 0; i5 < iO; i5++) {
            arrayList.add(ULong.a(ULongArray.l(jArr, i5)));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m2156takeLastPpDY95g(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$takeLast$0");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt.emptyList();
        }
        int iO = UByteArray.o(bArr);
        if (i3 >= iO) {
            return CollectionsKt.toList(UByteArray.a(bArr));
        }
        if (i3 == 1) {
            return CollectionsKt.listOf(UByte.a(UByteArray.l(bArr, iO - 1)));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = iO - i3; i4 < iO; i4++) {
            arrayList.add(UByte.a(UByteArray.l(bArr, i4)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m2157takeLastnggk6HY(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$takeLast$0");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt.emptyList();
        }
        int iO = UShortArray.o(sArr);
        if (i3 >= iO) {
            return CollectionsKt.toList(UShortArray.a(sArr));
        }
        if (i3 == 1) {
            return CollectionsKt.listOf(UShort.a(UShortArray.l(sArr, iO - 1)));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = iO - i3; i4 < iO; i4++) {
            arrayList.add(UShort.a(UShortArray.l(sArr, i4)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m2158takeLastqFRl0hI(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$takeLast$0");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt.emptyList();
        }
        int iO = UIntArray.o(iArr);
        if (i3 >= iO) {
            return CollectionsKt.toList(UIntArray.a(iArr));
        }
        if (i3 == 1) {
            return CollectionsKt.listOf(UInt.a(UIntArray.l(iArr, iO - 1)));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = iO - i3; i4 < iO; i4++) {
            arrayList.add(UInt.a(UIntArray.l(iArr, i4)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m2159takeLastr7IrZao(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$takeLast$0");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt.emptyList();
        }
        int iO = ULongArray.o(jArr);
        if (i3 >= iO) {
            return CollectionsKt.toList(ULongArray.a(jArr));
        }
        if (i3 == 1) {
            return CollectionsKt.listOf(ULong.a(ULongArray.l(jArr, iO - 1)));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = iO - i3; i4 < iO; i4++) {
            arrayList.add(ULong.a(ULongArray.l(jArr, i4)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLastWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m2160takeLastWhileJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$takeLastWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt.getLastIndex(bArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(UByte.a(UByteArray.l(bArr, lastIndex)))).booleanValue()) {
                return m1628dropPpDY95g(bArr, lastIndex + 1);
            }
        }
        return CollectionsKt.toList(UByteArray.a(bArr));
    }

    /* JADX INFO: renamed from: takeLastWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m2161takeLastWhileMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$takeLastWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt.getLastIndex(jArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(ULong.a(ULongArray.l(jArr, lastIndex)))).booleanValue()) {
                return m1631dropr7IrZao(jArr, lastIndex + 1);
            }
        }
        return CollectionsKt.toList(ULongArray.a(jArr));
    }

    /* JADX INFO: renamed from: takeLastWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m2163takeLastWhilexTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$takeLastWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt.getLastIndex(sArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(UShort.a(UShortArray.l(sArr, lastIndex)))).booleanValue()) {
                return m1629dropnggk6HY(sArr, lastIndex + 1);
            }
        }
        return CollectionsKt.toList(UShortArray.a(sArr));
    }

    /* JADX INFO: renamed from: takeWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m2164takeWhileJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$takeWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            if (!((Boolean) predicate.invoke(UByte.a(bL))).booleanValue()) {
                break;
            }
            arrayList.add(UByte.a(bL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m2165takeWhileMShoTSo(long[] jArr, Function1<? super ULong, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$takeWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            if (!((Boolean) predicate.invoke(ULong.a(jL))).booleanValue()) {
                break;
            }
            arrayList.add(ULong.a(jL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m2166takeWhilejgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$takeWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            if (!((Boolean) predicate.invoke(UInt.a(iL))).booleanValue()) {
                break;
            }
            arrayList.add(UInt.a(iL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m2167takeWhilexTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$takeWhile$0");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            if (!((Boolean) predicate.invoke(UShort.a(sL))).booleanValue()) {
                break;
            }
            arrayList.add(UShort.a(sL));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: toByteArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m2168toByteArrayGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$toByteArray$0");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    /* JADX INFO: renamed from: toIntArray--ajY-9A, reason: not valid java name */
    private static final int[] m2169toIntArrayajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$toIntArray$0");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    /* JADX INFO: renamed from: toLongArray-QwZRm1k, reason: not valid java name */
    private static final long[] m2170toLongArrayQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$toLongArray$0");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    /* JADX INFO: renamed from: toShortArray-rL5Bavg, reason: not valid java name */
    private static final short[] m2171toShortArrayrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$toShortArray$0");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    /* JADX INFO: renamed from: toTypedArray--ajY-9A, reason: not valid java name */
    public static final UInt[] m2172toTypedArrayajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$toTypedArray$0");
        int iO = UIntArray.o(iArr);
        UInt[] uIntArr = new UInt[iO];
        for (int i3 = 0; i3 < iO; i3++) {
            uIntArr[i3] = UInt.a(UIntArray.l(iArr, i3));
        }
        return uIntArr;
    }

    /* JADX INFO: renamed from: toTypedArray-GBYM_sE, reason: not valid java name */
    public static final UByte[] m2173toTypedArrayGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$toTypedArray$0");
        int iO = UByteArray.o(bArr);
        UByte[] uByteArr = new UByte[iO];
        for (int i3 = 0; i3 < iO; i3++) {
            uByteArr[i3] = UByte.a(UByteArray.l(bArr, i3));
        }
        return uByteArr;
    }

    /* JADX INFO: renamed from: toTypedArray-QwZRm1k, reason: not valid java name */
    public static final ULong[] m2174toTypedArrayQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$toTypedArray$0");
        int iO = ULongArray.o(jArr);
        ULong[] uLongArr = new ULong[iO];
        for (int i3 = 0; i3 < iO; i3++) {
            uLongArr[i3] = ULong.a(ULongArray.l(jArr, i3));
        }
        return uLongArr;
    }

    /* JADX INFO: renamed from: toTypedArray-rL5Bavg, reason: not valid java name */
    public static final UShort[] m2175toTypedArrayrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$toTypedArray$0");
        int iO = UShortArray.o(sArr);
        UShort[] uShortArr = new UShort[iO];
        for (int i3 = 0; i3 < iO; i3++) {
            uShortArr[i3] = UShort.a(UShortArray.l(sArr, i3));
        }
        return uShortArr;
    }

    public static final byte[] toUByteArray(UByte[] uByteArr) {
        Intrinsics.checkNotNullParameter(uByteArr, "<this>");
        int length = uByteArr.length;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = uByteArr[i3].f();
        }
        return UByteArray.d(bArr);
    }

    public static final int[] toUIntArray(UInt[] uIntArr) {
        Intrinsics.checkNotNullParameter(uIntArr, "<this>");
        int length = uIntArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = uIntArr[i3].f();
        }
        return UIntArray.d(iArr);
    }

    public static final long[] toULongArray(ULong[] uLongArr) {
        Intrinsics.checkNotNullParameter(uLongArr, "<this>");
        int length = uLongArr.length;
        long[] jArr = new long[length];
        for (int i3 = 0; i3 < length; i3++) {
            jArr[i3] = uLongArr[i3].g();
        }
        return ULongArray.d(jArr);
    }

    public static final short[] toUShortArray(UShort[] uShortArr) {
        Intrinsics.checkNotNullParameter(uShortArr, "<this>");
        int length = uShortArr.length;
        short[] sArr = new short[length];
        for (int i3 = 0; i3 < length; i3++) {
            sArr[i3] = uShortArr[i3].f();
        }
        return UShortArray.d(sArr);
    }

    /* JADX INFO: renamed from: withIndex--ajY-9A, reason: not valid java name */
    public static final Iterable<IndexedValue<UInt>> m2176withIndexajY9A(final int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$withIndex$0");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UIntArray.s(iArr);
            }
        });
    }

    /* JADX INFO: renamed from: withIndex-GBYM_sE, reason: not valid java name */
    public static final Iterable<IndexedValue<UByte>> m2177withIndexGBYM_sE(final byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$withIndex$0");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UByteArray.s(bArr);
            }
        });
    }

    /* JADX INFO: renamed from: withIndex-QwZRm1k, reason: not valid java name */
    public static final Iterable<IndexedValue<ULong>> m2178withIndexQwZRm1k(final long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$withIndex$0");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ULongArray.s(jArr);
            }
        });
    }

    /* JADX INFO: renamed from: withIndex-rL5Bavg, reason: not valid java name */
    public static final Iterable<IndexedValue<UShort>> m2179withIndexrL5Bavg(final short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$withIndex$0");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UShortArray.s(sArr);
            }
        });
    }

    /* JADX INFO: renamed from: zip-7znnbtw, reason: not valid java name */
    private static final <R, V> List<V> m2180zip7znnbtw(int[] iArr, Iterable<? extends R> other, Function2<? super UInt, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UIntArray.o(iArr);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iO));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= iO) {
                break;
            }
            arrayList.add(transform.invoke(UInt.a(UIntArray.l(iArr, i3)), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-8LME4QE, reason: not valid java name */
    private static final <R, V> List<V> m2181zip8LME4QE(long[] jArr, R[] other, Function2<? super ULong, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(ULongArray.o(jArr), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(ULong.a(ULongArray.l(jArr, i3)), other[i3]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-C-E_24M, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m2182zipCE_24M(int[] iArr, R[] other) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UIntArray.o(iArr), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            int iL = UIntArray.l(iArr, i3);
            arrayList.add(TuplesKt.a(UInt.a(iL), other[i3]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-F7u83W8, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m2183zipF7u83W8(long[] jArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        int iO = ULongArray.o(jArr);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iO));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= iO) {
                break;
            }
            arrayList.add(TuplesKt.a(ULong.a(ULongArray.l(jArr, i3)), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-HwE9HBo, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m2184zipHwE9HBo(int[] iArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        int iO = UIntArray.o(iArr);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iO));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= iO) {
                break;
            }
            arrayList.add(TuplesKt.a(UInt.a(UIntArray.l(iArr, i3)), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-JAKpvQM, reason: not valid java name */
    private static final <V> List<V> m2185zipJAKpvQM(byte[] bArr, byte[] bArr2, Function2<? super UByte, ? super UByte, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(bArr2, "$v$c$kotlin-UByteArray$-other$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UByteArray.o(bArr), UByteArray.o(bArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(UByte.a(UByteArray.l(bArr, i3)), UByte.a(UByteArray.l(bArr2, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-JGPC0-M, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m2186zipJGPC0M(short[] sArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        int iO = UShortArray.o(sArr);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iO));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= iO) {
                break;
            }
            arrayList.add(TuplesKt.a(UShort.a(UShortArray.l(sArr, i3)), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-JQknh5Q, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m2187zipJQknh5Q(byte[] bArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        int iO = UByteArray.o(bArr);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iO));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= iO) {
                break;
            }
            arrayList.add(TuplesKt.a(UByte.a(UByteArray.l(bArr, i3)), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-L83TJbI, reason: not valid java name */
    private static final <V> List<V> m2188zipL83TJbI(int[] iArr, int[] iArr2, Function2<? super UInt, ? super UInt, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(iArr2, "$v$c$kotlin-UIntArray$-other$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UIntArray.o(iArr), UIntArray.o(iArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(UInt.a(UIntArray.l(iArr, i3)), UInt.a(UIntArray.l(iArr2, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-LuipOMY, reason: not valid java name */
    private static final <R, V> List<V> m2189zipLuipOMY(byte[] bArr, R[] other, Function2<? super UByte, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UByteArray.o(bArr), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(UByte.a(UByteArray.l(bArr, i3)), other[i3]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-PabeH-Q, reason: not valid java name */
    private static final <V> List<V> m2190zipPabeHQ(long[] jArr, long[] jArr2, Function2<? super ULong, ? super ULong, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(jArr2, "$v$c$kotlin-ULongArray$-other$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(ULongArray.o(jArr), ULongArray.o(jArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(ULong.a(ULongArray.l(jArr, i3)), ULong.a(ULongArray.l(jArr2, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-TUPTUsU, reason: not valid java name */
    private static final <R, V> List<V> m2191zipTUPTUsU(long[] jArr, Iterable<? extends R> other, Function2<? super ULong, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = ULongArray.o(jArr);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iO));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= iO) {
                break;
            }
            arrayList.add(transform.invoke(ULong.a(ULongArray.l(jArr, i3)), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-UCnP4_w, reason: not valid java name */
    private static final <R, V> List<V> m2192zipUCnP4_w(byte[] bArr, Iterable<? extends R> other, Function2<? super UByte, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UByteArray.o(bArr);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iO));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= iO) {
                break;
            }
            arrayList.add(transform.invoke(UByte.a(UByteArray.l(bArr, i3)), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-ZjwqOic, reason: not valid java name */
    private static final <R, V> List<V> m2193zipZjwqOic(int[] iArr, R[] other, Function2<? super UInt, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UIntArray.o(iArr), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(UInt.a(UIntArray.l(iArr, i3)), other[i3]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-ctEhBpI, reason: not valid java name */
    public static final List<Pair<UInt, UInt>> m2194zipctEhBpI(int[] iArr, int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(iArr2, "$v$c$kotlin-UIntArray$-other$0");
        int iMin = Math.min(UIntArray.o(iArr), UIntArray.o(iArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(UInt.a(UIntArray.l(iArr, i3)), UInt.a(UIntArray.l(iArr2, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-ePBmRWY, reason: not valid java name */
    private static final <R, V> List<V> m2195zipePBmRWY(short[] sArr, R[] other, Function2<? super UShort, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UShortArray.o(sArr), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(UShort.a(UShortArray.l(sArr, i3)), other[i3]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-f7H3mmw, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m2196zipf7H3mmw(long[] jArr, R[] other) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(ULongArray.o(jArr), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            long jL = ULongArray.l(jArr, i3);
            arrayList.add(TuplesKt.a(ULong.a(jL), other[i3]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-gVVukQo, reason: not valid java name */
    private static final <V> List<V> m2197zipgVVukQo(short[] sArr, short[] sArr2, Function2<? super UShort, ? super UShort, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(sArr2, "$v$c$kotlin-UShortArray$-other$0");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(UShortArray.o(sArr), UShortArray.o(sArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(UShort.a(UShortArray.l(sArr, i3)), UShort.a(UShortArray.l(sArr2, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-kBb4a-s, reason: not valid java name */
    private static final <R, V> List<V> m2198zipkBb4as(short[] sArr, Iterable<? extends R> other, Function2<? super UShort, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iO = UShortArray.o(sArr);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iO));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= iO) {
                break;
            }
            arrayList.add(transform.invoke(UShort.a(UShortArray.l(sArr, i3)), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-kdPth3s, reason: not valid java name */
    public static final List<Pair<UByte, UByte>> m2199zipkdPth3s(byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(bArr2, "$v$c$kotlin-UByteArray$-other$0");
        int iMin = Math.min(UByteArray.o(bArr), UByteArray.o(bArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(UByte.a(UByteArray.l(bArr, i3)), UByte.a(UByteArray.l(bArr2, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-mazbYpA, reason: not valid java name */
    public static final List<Pair<UShort, UShort>> m2200zipmazbYpA(short[] sArr, short[] sArr2) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(sArr2, "$v$c$kotlin-UShortArray$-other$0");
        int iMin = Math.min(UShortArray.o(sArr), UShortArray.o(sArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(UShort.a(UShortArray.l(sArr, i3)), UShort.a(UShortArray.l(sArr2, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-nl983wc, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m2201zipnl983wc(byte[] bArr, R[] other) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UByteArray.o(bArr), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            byte bL = UByteArray.l(bArr, i3);
            arrayList.add(TuplesKt.a(UByte.a(bL), other[i3]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-uaTIQ5s, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m2202zipuaTIQ5s(short[] sArr, R[] other) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UShortArray.o(sArr), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            short sL = UShortArray.l(sArr, i3);
            arrayList.add(TuplesKt.a(UShort.a(sL), other[i3]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-us8wMrg, reason: not valid java name */
    public static final List<Pair<ULong, ULong>> m2203zipus8wMrg(long[] jArr, long[] jArr2) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        Intrinsics.checkNotNullParameter(jArr2, "$v$c$kotlin-ULongArray$-other$0");
        int iMin = Math.min(ULongArray.o(jArr), ULongArray.o(jArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(ULong.a(ULongArray.l(jArr, i3)), ULong.a(ULongArray.l(jArr2, i3))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: any-xTcfx_M, reason: not valid java name */
    private static final boolean m1555anyxTcfx_M(short[] sArr, Function1<? super UShort, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, cJfnYMIyomoWf.YNgIQxTgc);
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            if (((Boolean) predicate.invoke(UShort.a(UShortArray.l(sArr, i3)))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWithTo-ciTST-8, reason: not valid java name */
    private static final <V, M extends Map<? super UShort, ? super V>> M m1567associateWithTociTST8(short[] sArr, M m3, Function1<? super UShort, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$associateWithTo$0");
        Intrinsics.checkNotNullParameter(m3, vxrlPPpdv.LIIah);
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            short sL = UShortArray.l(sArr, i3);
            m3.put(UShort.a(sL), valueSelector.invoke(UShort.a(sL)));
        }
        return m3;
    }

    /* JADX INFO: renamed from: dropLastWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m1636dropLastWhileJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, YvFRmou.MLcbSnTzpjdC);
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = ArraysKt.getLastIndex(bArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(UByte.a(UByteArray.l(bArr, lastIndex)))).booleanValue()) {
                return m2152takePpDY95g(bArr, lastIndex + 1);
            }
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: dropWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m1642dropWhilejgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$dropWhile$0");
        Intrinsics.checkNotNullParameter(function1, bfIdKSjLOVjG.biYePoLeUJApFD);
        ArrayList arrayList = new ArrayList();
        int iO = UIntArray.o(iArr);
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            int iL = UIntArray.l(iArr, i3);
            if (z2) {
                arrayList.add(UInt.a(iL));
            } else if (!((Boolean) function1.invoke(UInt.a(iL))).booleanValue()) {
                arrayList.add(UInt.a(iL));
                z2 = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNot-MShoTSo, reason: not valid java name */
    private static final List<ULong> m1673filterNotMShoTSo(long[] jArr, Function1<? super ULong, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$filterNot$0");
        Intrinsics.checkNotNullParameter(function1, jTYhJgqLBN.EjdPFywswtOV);
        ArrayList arrayList = new ArrayList();
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            long jL = ULongArray.l(jArr, i3);
            if (!((Boolean) function1.invoke(ULong.a(jL))).booleanValue()) {
                arrayList.add(ULong.a(jL));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: last-JOV_ifY, reason: not valid java name */
    private static final byte m1802lastJOV_ifY(byte[] bArr, Function1<? super UByte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$last$0");
        Intrinsics.checkNotNullParameter(function1, cJfnYMIyomoWf.xSnccKhmN);
        int iO = UByteArray.o(bArr) - 1;
        if (iO >= 0) {
            while (true) {
                int i3 = iO - 1;
                byte bL = UByteArray.l(bArr, iO);
                if (!((Boolean) function1.invoke(UByte.a(bL))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    iO = i3;
                } else {
                    return bL;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: maxByOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UByte m1836maxByOrNullJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxByOrNull$0");
        Intrinsics.checkNotNullParameter(function1, wgbAZXYjrv.zipcrU);
        if (UByteArray.q(bArr)) {
            return null;
        }
        byte bL = UByteArray.l(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        if (lastIndex == 0) {
            return UByte.a(bL);
        }
        Comparable comparable = (Comparable) function1.invoke(UByte.a(bL));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bL2 = UByteArray.l(bArr, i3);
                Comparable comparable2 = (Comparable) function1.invoke(UByte.a(bL2));
                if (comparable.compareTo(comparable2) < 0) {
                    bL = bL2;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UByte.a(bL);
    }

    /* JADX INFO: renamed from: maxOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m1879maxOrNullrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, CbYNFSEGaQj.xnJkKbIcRGd);
        if (UShortArray.q(sArr)) {
            return null;
        }
        short sL = UShortArray.l(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sL2 = UShortArray.l(sArr, i3);
                if (Intrinsics.compare(sL & 65535, 65535 & sL2) < 0) {
                    sL = sL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return UShort.a(sL);
    }

    /* JADX INFO: renamed from: minOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m1934minOrNullQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, jTYhJgqLBN.ZOcYvnwjN);
        if (ULongArray.q(jArr)) {
            return null;
        }
        long jL = ULongArray.l(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jL2 = ULongArray.l(jArr, i3);
                if (Long.compareUnsigned(jL, jL2) > 0) {
                    jL = jL2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return ULong.a(jL);
    }

    /* JADX INFO: renamed from: plus-us8wMrg, reason: not valid java name */
    private static final long[] m1974plusus8wMrg(long[] jArr, long[] jArr2) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$plus$0");
        Intrinsics.checkNotNullParameter(jArr2, pMpIcGE.izYFuaLP);
        return ULongArray.d(ArraysKt.plus(jArr, jArr2));
    }

    /* JADX INFO: renamed from: sortedArray-QwZRm1k, reason: not valid java name */
    public static final long[] m2130sortedArrayQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sortedArray$0");
        if (ULongArray.q(jArr)) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, qRMDmh.tlSnu);
        long[] jArrD = ULongArray.d(jArrCopyOf);
        m2112sortQwZRm1k(jArrD);
        return jArrD;
    }

    /* JADX INFO: renamed from: takeLastWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m2162takeLastWhilejgv0xPQ(int[] iArr, Function1<? super UInt, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$takeLastWhile$0");
        Intrinsics.checkNotNullParameter(function1, CbYNFSEGaQj.YxlePjwtfSkgx);
        for (int lastIndex = ArraysKt.getLastIndex(iArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) function1.invoke(UInt.a(UIntArray.l(iArr, lastIndex)))).booleanValue()) {
                return m1630dropqFRl0hI(iArr, lastIndex + 1);
            }
        }
        return CollectionsKt.toList(UIntArray.a(iArr));
    }

    private static final byte[] toUByteArray(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return UByteArray.d(bArrCopyOf);
    }

    private static final int[] toUIntArray(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return UIntArray.d(iArrCopyOf);
    }

    private static final long[] toULongArray(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return ULongArray.d(jArrCopyOf);
    }

    private static final short[] toUShortArray(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return UShortArray.d(sArrCopyOf);
    }

    private static final double sumOfDouble(long[] jArr, Function1<? super ULong, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = ULongArray.o(jArr);
        double dDoubleValue = 0.0d;
        for (int i3 = 0; i3 < iO; i3++) {
            dDoubleValue += ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(long[] jArr, Function1<? super ULong, Integer> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = ULongArray.o(jArr);
        int iIntValue = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            iIntValue += ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(long[] jArr, Function1<? super ULong, Long> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = ULongArray.o(jArr);
        long jLongValue = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            jLongValue += ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).longValue();
        }
        return jLongValue;
    }

    private static final int sumOfUInt(long[] jArr, Function1<? super ULong, UInt> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            iB = UInt.b(iB + ((UInt) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).f());
        }
        return iB;
    }

    private static final long sumOfULong(long[] jArr, Function1<? super ULong, ULong> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            jB = ULong.b(jB + ((ULong) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).g());
        }
        return jB;
    }

    private static final double sumOfDouble(byte[] bArr, Function1<? super UByte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UByteArray.o(bArr);
        double dDoubleValue = 0.0d;
        for (int i3 = 0; i3 < iO; i3++) {
            dDoubleValue += ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(byte[] bArr, Function1<? super UByte, Integer> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UByteArray.o(bArr);
        int iIntValue = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            iIntValue += ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(byte[] bArr, Function1<? super UByte, Long> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UByteArray.o(bArr);
        long jLongValue = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            jLongValue += ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).longValue();
        }
        return jLongValue;
    }

    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final float m1845maxOfJOV_ifY(byte[] bArr, Function1<? super UByte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UByteArray.q(bArr)) {
            float fFloatValue = ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, 0)))).floatValue();
            int lastIndex = ArraysKt.getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final float m1848maxOfMShoTSo(long[] jArr, Function1<? super ULong, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!ULongArray.q(jArr)) {
            float fFloatValue = ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, 0)))).floatValue();
            int lastIndex = ArraysKt.getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final float m1851maxOfjgv0xPQ(int[] iArr, Function1<? super UInt, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UIntArray.q(iArr)) {
            float fFloatValue = ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, 0)))).floatValue();
            int lastIndex = ArraysKt.getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final float m1854maxOfxTcfx_M(short[] sArr, Function1<? super UShort, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UShortArray.q(sArr)) {
            float fFloatValue = ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, 0)))).floatValue();
            int lastIndex = ArraysKt.getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Float m1858maxOfOrNullJOV_ifY(byte[] bArr, Function1<? super UByte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, 0)))).floatValue();
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final Float m1861maxOfOrNullMShoTSo(long[] jArr, Function1<? super ULong, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, 0)))).floatValue();
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Float m1864maxOfOrNulljgv0xPQ(int[] iArr, Function1<? super UInt, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, 0)))).floatValue();
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Float m1867maxOfOrNullxTcfx_M(short[] sArr, Function1<? super UShort, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, 0)))).floatValue();
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final long m1882maxOrThrowU(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$max$0");
        if (!ULongArray.q(jArr)) {
            long jL = ULongArray.l(jArr, 0);
            int lastIndex = ArraysKt.getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jL2 = ULongArray.l(jArr, i3);
                    if (Long.compareUnsigned(jL, jL2) < 0) {
                        jL = jL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return jL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final long m1890maxWithOrThrowU(long[] jArr, Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!ULongArray.q(jArr)) {
            long jL = ULongArray.l(jArr, 0);
            int lastIndex = ArraysKt.getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jL2 = ULongArray.l(jArr, i3);
                    if (comparator.compare(ULong.a(jL), ULong.a(jL2)) < 0) {
                        jL = jL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return jL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final float m1901minOfJOV_ifY(byte[] bArr, Function1<? super UByte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UByteArray.q(bArr)) {
            float fFloatValue = ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, 0)))).floatValue();
            int lastIndex = ArraysKt.getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final float m1904minOfMShoTSo(long[] jArr, Function1<? super ULong, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!ULongArray.q(jArr)) {
            float fFloatValue = ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, 0)))).floatValue();
            int lastIndex = ArraysKt.getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final float m1907minOfjgv0xPQ(int[] iArr, Function1<? super UInt, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UIntArray.q(iArr)) {
            float fFloatValue = ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, 0)))).floatValue();
            int lastIndex = ArraysKt.getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final float m1910minOfxTcfx_M(short[] sArr, Function1<? super UShort, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UShortArray.q(sArr)) {
            float fFloatValue = ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, 0)))).floatValue();
            int lastIndex = ArraysKt.getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Float m1914minOfOrNullJOV_ifY(byte[] bArr, Function1<? super UByte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, 0)))).floatValue();
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final Float m1917minOfOrNullMShoTSo(long[] jArr, Function1<? super ULong, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, 0)))).floatValue();
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(ULong.a(ULongArray.l(jArr, i3)))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Float m1920minOfOrNulljgv0xPQ(int[] iArr, Function1<? super UInt, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, 0)))).floatValue();
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(UInt.a(UIntArray.l(iArr, i3)))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Float m1923minOfOrNullxTcfx_M(short[] sArr, Function1<? super UShort, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, 0)))).floatValue();
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final long m1938minOrThrowU(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$min$0");
        if (!ULongArray.q(jArr)) {
            long jL = ULongArray.l(jArr, 0);
            int lastIndex = ArraysKt.getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jL2 = ULongArray.l(jArr, i3);
                    if (Long.compareUnsigned(jL, jL2) > 0) {
                        jL = jL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return jL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final long m1946minWithOrThrowU(long[] jArr, Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!ULongArray.q(jArr)) {
            long jL = ULongArray.l(jArr, 0);
            int lastIndex = ArraysKt.getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jL2 = ULongArray.l(jArr, i3);
                    if (comparator.compare(ULong.a(jL), ULong.a(jL2)) > 0) {
                        jL = jL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return jL;
        }
        throw new NoSuchElementException();
    }

    private static final double sumOfDouble(short[] sArr, Function1<? super UShort, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UShortArray.o(sArr);
        double dDoubleValue = 0.0d;
        for (int i3 = 0; i3 < iO; i3++) {
            dDoubleValue += ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(short[] sArr, Function1<? super UShort, Integer> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UShortArray.o(sArr);
        int iIntValue = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            iIntValue += ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(short[] sArr, Function1<? super UShort, Long> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iO = UShortArray.o(sArr);
        long jLongValue = 0;
        for (int i3 = 0; i3 < iO; i3++) {
            jLongValue += ((Number) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).longValue();
        }
        return jLongValue;
    }

    private static final int sumOfUInt(byte[] bArr, Function1<? super UByte, UInt> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(function1, qRMDmh.UoFjZWb);
        int iB = UInt.b(0);
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            iB = UInt.b(iB + ((UInt) function1.invoke(UByte.a(UByteArray.l(bArr, i3)))).f());
        }
        return iB;
    }

    private static final long sumOfULong(byte[] bArr, Function1<? super UByte, ULong> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            jB = ULong.b(jB + ((ULong) selector.invoke(UByte.a(UByteArray.l(bArr, i3)))).g());
        }
        return jB;
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> long m1842maxByOrThrowU(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!ULongArray.q(jArr)) {
            long jL = ULongArray.l(jArr, 0);
            int lastIndex = ArraysKt.getLastIndex(jArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(ULong.a(jL));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        long jL2 = ULongArray.l(jArr, i3);
                        Comparable comparable2 = (Comparable) selector.invoke(ULong.a(jL2));
                        if (comparable.compareTo(comparable2) < 0) {
                            jL = jL2;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return jL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> long m1898minByOrThrowU(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!ULongArray.q(jArr)) {
            long jL = ULongArray.l(jArr, 0);
            int lastIndex = ArraysKt.getLastIndex(jArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(ULong.a(jL));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        long jL2 = ULongArray.l(jArr, i3);
                        Comparable comparable2 = (Comparable) selector.invoke(ULong.a(jL2));
                        if (comparable.compareTo(comparable2) > 0) {
                            jL = jL2;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return jL;
        }
        throw new NoSuchElementException();
    }

    private static final int sumOfUInt(short[] sArr, Function1<? super UShort, UInt> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            iB = UInt.b(iB + ((UInt) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).f());
        }
        return iB;
    }

    private static final long sumOfULong(short[] sArr, Function1<? super UShort, ULong> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            jB = ULong.b(jB + ((ULong) selector.invoke(UShort.a(UShortArray.l(sArr, i3)))).g());
        }
        return jB;
    }

    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1846maxOfJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UByteArray.q(bArr)) {
            R r2 = (R) selector.invoke(UByte.a(UByteArray.l(bArr, 0)));
            int lastIndex = ArraysKt.getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(UByte.a(UByteArray.l(bArr, i3)));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1849maxOfMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!ULongArray.q(jArr)) {
            R r2 = (R) selector.invoke(ULong.a(ULongArray.l(jArr, 0)));
            int lastIndex = ArraysKt.getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(ULong.a(ULongArray.l(jArr, i3)));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1852maxOfjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UIntArray.q(iArr)) {
            R r2 = (R) selector.invoke(UInt.a(UIntArray.l(iArr, 0)));
            int lastIndex = ArraysKt.getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(UInt.a(UIntArray.l(iArr, i3)));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1855maxOfxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UShortArray.q(sArr)) {
            R r2 = (R) selector.invoke(UShort.a(UShortArray.l(sArr, 0)));
            int lastIndex = ArraysKt.getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(UShort.a(UShortArray.l(sArr, i3)));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1856maxOfOrNullJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            return null;
        }
        R r2 = (R) selector.invoke(UByte.a(UByteArray.l(bArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(UByte.a(UByteArray.l(bArr, i3)));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1859maxOfOrNullMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            return null;
        }
        R r2 = (R) selector.invoke(ULong.a(ULongArray.l(jArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(ULong.a(ULongArray.l(jArr, i3)));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1862maxOfOrNulljgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            return null;
        }
        R r2 = (R) selector.invoke(UInt.a(UIntArray.l(iArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(UInt.a(UIntArray.l(iArr, i3)));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1865maxOfOrNullxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            return null;
        }
        R r2 = (R) selector.invoke(UShort.a(UShortArray.l(sArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(UShort.a(UShortArray.l(sArr, i3)));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final byte m1880maxOrThrowU(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$max$0");
        if (!UByteArray.q(bArr)) {
            byte bL = UByteArray.l(bArr, 0);
            int lastIndex = ArraysKt.getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bL2 = UByteArray.l(bArr, i3);
                    if (Intrinsics.compare(bL & 255, bL2 & 255) < 0) {
                        bL = bL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return bL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final byte m1888maxWithOrThrowU(byte[] bArr, Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!UByteArray.q(bArr)) {
            byte bL = UByteArray.l(bArr, 0);
            int lastIndex = ArraysKt.getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bL2 = UByteArray.l(bArr, i3);
                    if (comparator.compare(UByte.a(bL), UByte.a(bL2)) < 0) {
                        bL = bL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return bL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1902minOfJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UByteArray.q(bArr)) {
            R r2 = (R) selector.invoke(UByte.a(UByteArray.l(bArr, 0)));
            int lastIndex = ArraysKt.getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(UByte.a(UByteArray.l(bArr, i3)));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1905minOfMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!ULongArray.q(jArr)) {
            R r2 = (R) selector.invoke(ULong.a(ULongArray.l(jArr, 0)));
            int lastIndex = ArraysKt.getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(ULong.a(ULongArray.l(jArr, i3)));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1908minOfjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UIntArray.q(iArr)) {
            R r2 = (R) selector.invoke(UInt.a(UIntArray.l(iArr, 0)));
            int lastIndex = ArraysKt.getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(UInt.a(UIntArray.l(iArr, i3)));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1911minOfxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UShortArray.q(sArr)) {
            R r2 = (R) selector.invoke(UShort.a(UShortArray.l(sArr, 0)));
            int lastIndex = ArraysKt.getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(UShort.a(UShortArray.l(sArr, i3)));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1912minOfOrNullJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.q(bArr)) {
            return null;
        }
        R r2 = (R) selector.invoke(UByte.a(UByteArray.l(bArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(UByte.a(UByteArray.l(bArr, i3)));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1915minOfOrNullMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.q(jArr)) {
            return null;
        }
        R r2 = (R) selector.invoke(ULong.a(ULongArray.l(jArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(ULong.a(ULongArray.l(jArr, i3)));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1918minOfOrNulljgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.q(iArr)) {
            return null;
        }
        R r2 = (R) selector.invoke(UInt.a(UIntArray.l(iArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(UInt.a(UIntArray.l(iArr, i3)));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m1921minOfOrNullxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minOfOrNull$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.q(sArr)) {
            return null;
        }
        R r2 = (R) selector.invoke(UShort.a(UShortArray.l(sArr, 0)));
        int lastIndex = ArraysKt.getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(UShort.a(UShortArray.l(sArr, i3)));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final byte m1936minOrThrowU(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$min$0");
        if (!UByteArray.q(bArr)) {
            byte bL = UByteArray.l(bArr, 0);
            int lastIndex = ArraysKt.getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bL2 = UByteArray.l(bArr, i3);
                    if (Intrinsics.compare(bL & 255, bL2 & 255) > 0) {
                        bL = bL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return bL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final byte m1944minWithOrThrowU(byte[] bArr, Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!UByteArray.q(bArr)) {
            byte bL = UByteArray.l(bArr, 0);
            int lastIndex = ArraysKt.getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bL2 = UByteArray.l(bArr, i3);
                    if (comparator.compare(UByte.a(bL), UByte.a(bL2)) > 0) {
                        bL = bL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return bL;
        }
        throw new NoSuchElementException();
    }

    public static final int sumOfUInt(UInt[] uIntArr) {
        Intrinsics.checkNotNullParameter(uIntArr, "<this>");
        int iB = 0;
        for (UInt uInt : uIntArr) {
            iB = UInt.b(iB + uInt.f());
        }
        return iB;
    }

    public static final long sumOfULong(ULong[] uLongArr) {
        Intrinsics.checkNotNullParameter(uLongArr, "<this>");
        long jB = 0;
        for (ULong uLong : uLongArr) {
            jB = ULong.b(jB + uLong.g());
        }
        return jB;
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> byte m1840maxByOrThrowU(byte[] bArr, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UByteArray.q(bArr)) {
            byte bL = UByteArray.l(bArr, 0);
            int lastIndex = ArraysKt.getLastIndex(bArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(UByte.a(bL));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        byte bL2 = UByteArray.l(bArr, i3);
                        Comparable comparable2 = (Comparable) selector.invoke(UByte.a(bL2));
                        if (comparable.compareTo(comparable2) < 0) {
                            bL = bL2;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return bL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> byte m1896minByOrThrowU(byte[] bArr, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UByteArray.q(bArr)) {
            byte bL = UByteArray.l(bArr, 0);
            int lastIndex = ArraysKt.getLastIndex(bArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(UByte.a(bL));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        byte bL2 = UByteArray.l(bArr, i3);
                        Comparable comparable2 = (Comparable) selector.invoke(UByte.a(bL2));
                        if (comparable.compareTo(comparable2) > 0) {
                            bL = bL2;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return bL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final short m1883maxOrThrowU(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$max$0");
        if (!UShortArray.q(sArr)) {
            short sL = UShortArray.l(sArr, 0);
            int lastIndex = ArraysKt.getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sL2 = UShortArray.l(sArr, i3);
                    if (Intrinsics.compare(sL & 65535, 65535 & sL2) < 0) {
                        sL = sL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return sL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final short m1891maxWithOrThrowU(short[] sArr, Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!UShortArray.q(sArr)) {
            short sL = UShortArray.l(sArr, 0);
            int lastIndex = ArraysKt.getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sL2 = UShortArray.l(sArr, i3);
                    if (comparator.compare(UShort.a(sL), UShort.a(sL2)) < 0) {
                        sL = sL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return sL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final short m1939minOrThrowU(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$min$0");
        if (!UShortArray.q(sArr)) {
            short sL = UShortArray.l(sArr, 0);
            int lastIndex = ArraysKt.getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sL2 = UShortArray.l(sArr, i3);
                    if (Intrinsics.compare(sL & 65535, 65535 & sL2) > 0) {
                        sL = sL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return sL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final short m1947minWithOrThrowU(short[] sArr, Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!UShortArray.q(sArr)) {
            short sL = UShortArray.l(sArr, 0);
            int lastIndex = ArraysKt.getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sL2 = UShortArray.l(sArr, i3);
                    if (comparator.compare(UShort.a(sL), UShort.a(sL2)) > 0) {
                        sL = sL2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return sL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> short m1843maxByOrThrowU(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UShortArray.q(sArr)) {
            short sL = UShortArray.l(sArr, 0);
            int lastIndex = ArraysKt.getLastIndex(sArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(UShort.a(sL));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        short sL2 = UShortArray.l(sArr, i3);
                        Comparable comparable2 = (Comparable) selector.invoke(UShort.a(sL2));
                        if (comparable.compareTo(comparable2) < 0) {
                            sL = sL2;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return sL;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> short m1899minByOrThrowU(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (!UShortArray.q(sArr)) {
            short sL = UShortArray.l(sArr, 0);
            int lastIndex = ArraysKt.getLastIndex(sArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(UShort.a(sL));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        short sL2 = UShortArray.l(sArr, i3);
                        Comparable comparable2 = (Comparable) selector.invoke(UShort.a(sL2));
                        if (comparable.compareTo(comparable2) > 0) {
                            sL = sL2;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return sL;
        }
        throw new NoSuchElementException();
    }
}
