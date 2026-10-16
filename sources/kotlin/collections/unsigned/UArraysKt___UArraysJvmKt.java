package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
class UArraysKt___UArraysJvmKt {
    /* JADX INFO: renamed from: asList--ajY-9A, reason: not valid java name */
    public static final List<UInt> m1488asListajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$asList$0");
        return new UArraysKt___UArraysJvmKt$asList$1(iArr);
    }

    /* JADX INFO: renamed from: asList-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m1489asListGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$asList$0");
        return new UArraysKt___UArraysJvmKt$asList$3(bArr);
    }

    /* JADX INFO: renamed from: asList-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m1490asListQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$asList$0");
        return new UArraysKt___UArraysJvmKt$asList$2(jArr);
    }

    /* JADX INFO: renamed from: asList-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m1491asListrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$asList$0");
        return new UArraysKt___UArraysJvmKt$asList$4(sArr);
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s, reason: not valid java name */
    public static final int m1492binarySearch2fe2U9s(int[] iArr, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$binarySearch$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i4, i5, UIntArray.o(iArr));
        int i6 = i5 - 1;
        while (i4 <= i6) {
            int i7 = (i4 + i6) >>> 1;
            int iB = UnsignedKt.b(iArr[i7], i3);
            if (iB < 0) {
                i4 = i7 + 1;
            } else {
                if (iB <= 0) {
                    return i7;
                }
                i6 = i7 - 1;
            }
        }
        return -(i4 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ int m1493binarySearch2fe2U9s$default(int[] iArr, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = UIntArray.o(iArr);
        }
        return m1492binarySearch2fe2U9s(iArr, i3, i4, i5);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ, reason: not valid java name */
    public static final int m1494binarySearchEtDCXyQ(short[] sArr, short s2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$binarySearch$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, UShortArray.o(sArr));
        int i5 = s2 & 65535;
        int i6 = i4 - 1;
        while (i3 <= i6) {
            int i7 = (i3 + i6) >>> 1;
            int iB = UnsignedKt.b(sArr[i7], i5);
            if (iB < 0) {
                i3 = i7 + 1;
            } else {
                if (iB <= 0) {
                    return i7;
                }
                i6 = i7 - 1;
            }
        }
        return -(i3 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ int m1495binarySearchEtDCXyQ$default(short[] sArr, short s2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = UShortArray.o(sArr);
        }
        return m1494binarySearchEtDCXyQ(sArr, s2, i3, i4);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc, reason: not valid java name */
    public static final int m1496binarySearchK6DWlUc(long[] jArr, long j3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$binarySearch$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, ULongArray.o(jArr));
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int iD = UnsignedKt.d(jArr[i6], j3);
            if (iD < 0) {
                i3 = i6 + 1;
            } else {
                if (iD <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i3 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ int m1497binarySearchK6DWlUc$default(long[] jArr, long j3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = ULongArray.o(jArr);
        }
        return m1496binarySearchK6DWlUc(jArr, j3, i3, i4);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw, reason: not valid java name */
    public static final int m1498binarySearchWpHrYlw(byte[] bArr, byte b3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$binarySearch$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, UByteArray.o(bArr));
        int i5 = b3 & 255;
        int i6 = i4 - 1;
        while (i3 <= i6) {
            int i7 = (i3 + i6) >>> 1;
            int iB = UnsignedKt.b(bArr[i7], i5);
            if (iB < 0) {
                i3 = i7 + 1;
            } else {
                if (iB <= 0) {
                    return i7;
                }
                i6 = i7 - 1;
            }
        }
        return -(i3 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ int m1499binarySearchWpHrYlw$default(byte[] bArr, byte b3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = UByteArray.o(bArr);
        }
        return m1498binarySearchWpHrYlw(bArr, b3, i3, i4);
    }

    /* JADX INFO: renamed from: elementAt-PpDY95g, reason: not valid java name */
    private static final byte m1500elementAtPpDY95g(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$elementAt$0");
        return UByteArray.l(bArr, i3);
    }

    /* JADX INFO: renamed from: elementAt-nggk6HY, reason: not valid java name */
    private static final short m1501elementAtnggk6HY(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$elementAt$0");
        return UShortArray.l(sArr, i3);
    }

    /* JADX INFO: renamed from: elementAt-qFRl0hI, reason: not valid java name */
    private static final int m1502elementAtqFRl0hI(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$elementAt$0");
        return UIntArray.l(iArr, i3);
    }

    /* JADX INFO: renamed from: elementAt-r7IrZao, reason: not valid java name */
    private static final long m1503elementAtr7IrZao(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$elementAt$0");
        return ULongArray.l(jArr, i3);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: max--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m1504maxajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$max$0");
        return UArraysKt___UArraysKt.m1876maxOrNullajY9A(iArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: max-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m1505maxGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$max$0");
        return UArraysKt___UArraysKt.m1877maxOrNullGBYM_sE(bArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: max-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m1506maxQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$max$0");
        return UArraysKt___UArraysKt.m1878maxOrNullQwZRm1k(jArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: max-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m1507maxrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$max$0");
        return UArraysKt___UArraysKt.m1879maxOrNullrL5Bavg(sArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: maxBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m1508maxByJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxBy$0");
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

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: maxBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m1509maxByMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxBy$0");
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

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: maxBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m1510maxByjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxBy$0");
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

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: maxBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m1511maxByxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxBy$0");
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

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: maxWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m1512maxWithXMRcp5o(byte[] bArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m1884maxWithOrNullXMRcp5o(bArr, comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: maxWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m1513maxWithYmdZ_VM(int[] iArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m1885maxWithOrNullYmdZ_VM(iArr, comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: maxWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m1514maxWitheOHTfZs(short[] sArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m1886maxWithOrNulleOHTfZs(sArr, comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: maxWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m1515maxWithzrEWJaI(long[] jArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m1887maxWithOrNullzrEWJaI(jArr, comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: min--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m1516minajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$min$0");
        return UArraysKt___UArraysKt.m1932minOrNullajY9A(iArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: min-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m1517minGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$min$0");
        return UArraysKt___UArraysKt.m1933minOrNullGBYM_sE(bArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: min-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m1518minQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$min$0");
        return UArraysKt___UArraysKt.m1934minOrNullQwZRm1k(jArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: min-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m1519minrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$min$0");
        return UArraysKt___UArraysKt.m1935minOrNullrL5Bavg(sArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: minBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m1520minByJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minBy$0");
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

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: minBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m1521minByMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minBy$0");
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

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: minBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m1522minByjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minBy$0");
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

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: minBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m1523minByxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minBy$0");
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

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: minWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m1524minWithXMRcp5o(byte[] bArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m1940minWithOrNullXMRcp5o(bArr, comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: minWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m1525minWithYmdZ_VM(int[] iArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m1941minWithOrNullYmdZ_VM(iArr, comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: minWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m1526minWitheOHTfZs(short[] sArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m1942minWithOrNulleOHTfZs(sArr, comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: minWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m1527minWithzrEWJaI(long[] jArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m1943minWithOrNullzrEWJaI(jArr, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(int[] iArr, Function1<? super UInt, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(UInt.a(UIntArray.l(iArr, i3))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(int[] iArr, Function1<? super UInt, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        int iO = UIntArray.o(iArr);
        for (int i3 = 0; i3 < iO; i3++) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(UInt.a(UIntArray.l(iArr, i3))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    private static final BigDecimal sumOfBigDecimal(long[] jArr, Function1<? super ULong, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(ULong.a(ULongArray.l(jArr, i3))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(long[] jArr, Function1<? super ULong, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        int iO = ULongArray.o(jArr);
        for (int i3 = 0; i3 < iO; i3++) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(ULong.a(ULongArray.l(jArr, i3))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    private static final BigDecimal sumOfBigDecimal(byte[] bArr, Function1<? super UByte, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(UByte.a(UByteArray.l(bArr, i3))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(byte[] bArr, Function1<? super UByte, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        int iO = UByteArray.o(bArr);
        for (int i3 = 0; i3 < iO; i3++) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(UByte.a(UByteArray.l(bArr, i3))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    private static final BigDecimal sumOfBigDecimal(short[] sArr, Function1<? super UShort, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(UShort.a(UShortArray.l(sArr, i3))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(short[] sArr, Function1<? super UShort, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        int iO = UShortArray.o(sArr);
        for (int i3 = 0; i3 < iO; i3++) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(UShort.a(UShortArray.l(sArr, i3))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }
}
