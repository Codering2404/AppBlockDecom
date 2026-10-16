package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzht implements zzgx {
    public static final zzht zza = new zzht();

    private zzht() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i3, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        if (zzueVarArr.length != 2) {
            throw new zzce(4, 3, null);
        }
        Object objZza = zzgdVar.zzc().zza(zzueVarArr[0]);
        if (true != Objects.nonNull(objZza)) {
            objZza = null;
        }
        if (objZza == null) {
            throw new zzce(4, 5, null);
        }
        Object objZza2 = zzgdVar.zzc().zza(zzueVarArr[1]);
        if (true != Objects.nonNull(objZza2)) {
            objZza2 = null;
        }
        if (objZza2 == null) {
            throw new zzce(4, 5, null);
        }
        zzgdVar.zzc().zze(i3, zzb(objZza, objZza2));
    }

    public final Object zzb(Object obj, Object obj2) throws zzce {
        boolean z2 = obj instanceof Byte;
        if (z2 && (obj2 instanceof Byte)) {
            return Byte.valueOf((byte) (((Number) obj).byteValue() ^ ((Number) obj2).byteValue()));
        }
        boolean z3 = obj instanceof Short;
        if (z3 && (obj2 instanceof Short)) {
            return Short.valueOf((short) (((Number) obj).shortValue() ^ ((Number) obj2).shortValue()));
        }
        boolean z4 = obj instanceof Integer;
        if (z4 && (obj2 instanceof Integer)) {
            return Integer.valueOf(((Number) obj).intValue() ^ ((Number) obj2).intValue());
        }
        boolean z5 = obj instanceof Long;
        if (z5 && (obj2 instanceof Long)) {
            return Long.valueOf(((Number) obj2).longValue() ^ ((Number) obj).longValue());
        }
        int i3 = 0;
        if (obj instanceof String) {
            if (obj2 instanceof Byte) {
                byte[] bytes = ((String) obj).getBytes(Charsets.f140510b);
                int length = bytes.length;
                ArrayList arrayList = new ArrayList(length);
                while (i3 < length) {
                    arrayList.add(Byte.valueOf((byte) (bytes[i3] ^ ((Number) obj2).byteValue())));
                    i3++;
                }
                return CollectionsKt.toByteArray(arrayList);
            }
            if (obj2 instanceof Integer) {
                char[] charArray = ((String) obj).toCharArray();
                int length2 = charArray.length;
                ArrayList arrayList2 = new ArrayList(length2);
                while (i3 < length2) {
                    arrayList2.add(Integer.valueOf(charArray[i3] ^ ((Number) obj2).intValue()));
                    i3++;
                }
                return CollectionsKt.toIntArray(arrayList2);
            }
        }
        if (z2 && (obj2 instanceof byte[])) {
            byte[] bArr = (byte[]) obj2;
            ArrayList arrayList3 = new ArrayList(bArr.length);
            for (byte b3 : bArr) {
                arrayList3.add(Byte.valueOf((byte) (b3 ^ ((Number) obj).byteValue())));
            }
            return arrayList3.toArray(new Byte[0]);
        }
        if (z3 && (obj2 instanceof short[])) {
            short[] sArr = (short[]) obj2;
            ArrayList arrayList4 = new ArrayList(sArr.length);
            for (short s2 : sArr) {
                arrayList4.add(Short.valueOf((short) (s2 ^ ((Number) obj).shortValue())));
            }
            return arrayList4.toArray(new Short[0]);
        }
        if (z4 && (obj2 instanceof int[])) {
            int[] iArr = (int[]) obj2;
            ArrayList arrayList5 = new ArrayList(iArr.length);
            for (int i4 : iArr) {
                arrayList5.add(Integer.valueOf(i4 ^ ((Number) obj).intValue()));
            }
            return arrayList5.toArray(new Integer[0]);
        }
        if (z5 && (obj2 instanceof long[])) {
            long[] jArr = (long[]) obj2;
            ArrayList arrayList6 = new ArrayList(jArr.length);
            for (long j3 : jArr) {
                arrayList6.add(Long.valueOf(j3 ^ ((Number) obj).longValue()));
            }
            return arrayList6.toArray(new Long[0]);
        }
        boolean z6 = obj instanceof byte[];
        if (z6 && (obj2 instanceof Byte)) {
            byte[] bArr2 = (byte[]) obj;
            ArrayList arrayList7 = new ArrayList(bArr2.length);
            for (byte b4 : bArr2) {
                arrayList7.add(Byte.valueOf((byte) (b4 ^ ((Number) obj2).byteValue())));
            }
            return arrayList7.toArray(new Byte[0]);
        }
        boolean z7 = obj instanceof short[];
        if (z7 && (obj2 instanceof Short)) {
            short[] sArr2 = (short[]) obj;
            ArrayList arrayList8 = new ArrayList(sArr2.length);
            for (short s3 : sArr2) {
                arrayList8.add(Short.valueOf((short) (s3 ^ ((Number) obj2).shortValue())));
            }
            return arrayList8.toArray(new Short[0]);
        }
        boolean z8 = obj instanceof int[];
        if (z8 && (obj2 instanceof Integer)) {
            int[] iArr2 = (int[]) obj;
            ArrayList arrayList9 = new ArrayList(iArr2.length);
            for (int i5 : iArr2) {
                arrayList9.add(Integer.valueOf(i5 ^ ((Number) obj2).intValue()));
            }
            return arrayList9.toArray(new Integer[0]);
        }
        boolean z9 = obj instanceof long[];
        if (z9 && (obj2 instanceof Long)) {
            long[] jArr2 = (long[]) obj;
            ArrayList arrayList10 = new ArrayList(jArr2.length);
            for (long j4 : jArr2) {
                arrayList10.add(Long.valueOf(j4 ^ ((Number) obj2).longValue()));
            }
            return arrayList10.toArray(new Long[0]);
        }
        if (z6 && (obj2 instanceof byte[])) {
            byte[] bArr3 = (byte[]) obj;
            int length3 = bArr3.length;
            byte[] bArr4 = (byte[]) obj2;
            zzgw.zza(this, length3, bArr4.length);
            IntRange intRangeB = RangesKt.B(0, length3);
            ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB, 10));
            Iterator<Integer> it = intRangeB.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                arrayList11.add(Byte.valueOf((byte) (bArr4[iNextInt] ^ bArr3[iNextInt])));
            }
            return arrayList11.toArray(new Byte[0]);
        }
        if (z7 && (obj2 instanceof short[])) {
            short[] sArr3 = (short[]) obj;
            int length4 = sArr3.length;
            short[] sArr4 = (short[]) obj2;
            zzgw.zza(this, length4, sArr4.length);
            IntRange intRangeB2 = RangesKt.B(0, length4);
            ArrayList arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB2, 10));
            Iterator<Integer> it2 = intRangeB2.iterator();
            while (it2.hasNext()) {
                int iNextInt2 = ((IntIterator) it2).nextInt();
                arrayList12.add(Short.valueOf((short) (sArr4[iNextInt2] ^ sArr3[iNextInt2])));
            }
            return arrayList12.toArray(new Short[0]);
        }
        if (z8 && (obj2 instanceof int[])) {
            int[] iArr3 = (int[]) obj;
            int length5 = iArr3.length;
            int[] iArr4 = (int[]) obj2;
            zzgw.zza(this, length5, iArr4.length);
            IntRange intRangeB3 = RangesKt.B(0, length5);
            ArrayList arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB3, 10));
            Iterator<Integer> it3 = intRangeB3.iterator();
            while (it3.hasNext()) {
                int iNextInt3 = ((IntIterator) it3).nextInt();
                arrayList13.add(Integer.valueOf(iArr4[iNextInt3] ^ iArr3[iNextInt3]));
            }
            return arrayList13.toArray(new Integer[0]);
        }
        if (!z9 || !(obj2 instanceof long[])) {
            throw new zzce(4, 5, null);
        }
        long[] jArr3 = (long[]) obj;
        int length6 = jArr3.length;
        long[] jArr4 = (long[]) obj2;
        zzgw.zza(this, length6, jArr4.length);
        IntRange intRangeB4 = RangesKt.B(0, length6);
        ArrayList arrayList14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB4, 10));
        Iterator<Integer> it4 = intRangeB4.iterator();
        while (it4.hasNext()) {
            int iNextInt4 = ((IntIterator) it4).nextInt();
            arrayList14.add(Long.valueOf(jArr3[iNextInt4] ^ jArr4[iNextInt4]));
        }
        return arrayList14.toArray(new Long[0]);
    }
}
