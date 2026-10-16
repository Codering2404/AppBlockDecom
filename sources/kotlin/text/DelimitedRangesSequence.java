package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class DelimitedRangesSequence implements Sequence<IntRange> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f140518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f140520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function2 f140521d;

    /* JADX INFO: renamed from: kotlin.text.DelimitedRangesSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<IntRange>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f140522a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f140523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f140524c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private IntRange f140525d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f140526f;

        AnonymousClass1() {
            int iP = RangesKt.p(DelimitedRangesSequence.this.f140519b, 0, DelimitedRangesSequence.this.f140518a.length());
            this.f140523b = iP;
            this.f140524c = iP;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f140524c
                r1 = 0
                if (r0 >= 0) goto Lb
                r6.f140522a = r1
                r0 = 0
                r6.f140525d = r0
                return
            Lb:
                kotlin.text.DelimitedRangesSequence r0 = kotlin.text.DelimitedRangesSequence.this
                int r0 = kotlin.text.DelimitedRangesSequence.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L22
                int r0 = r6.f140526f
                int r0 = r0 + r3
                r6.f140526f = r0
                kotlin.text.DelimitedRangesSequence r4 = kotlin.text.DelimitedRangesSequence.this
                int r4 = kotlin.text.DelimitedRangesSequence.e(r4)
                if (r0 >= r4) goto L30
            L22:
                int r0 = r6.f140524c
                kotlin.text.DelimitedRangesSequence r4 = kotlin.text.DelimitedRangesSequence.this
                java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L46
            L30:
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r6.f140523b
                kotlin.text.DelimitedRangesSequence r4 = kotlin.text.DelimitedRangesSequence.this
                java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.d(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.h0(r4)
                r0.<init>(r1, r4)
                r6.f140525d = r0
                r6.f140524c = r2
                goto L9b
            L46:
                kotlin.text.DelimitedRangesSequence r0 = kotlin.text.DelimitedRangesSequence.this
                kotlin.jvm.functions.Function2 r0 = kotlin.text.DelimitedRangesSequence.c(r0)
                kotlin.text.DelimitedRangesSequence r4 = kotlin.text.DelimitedRangesSequence.this
                java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.d(r4)
                int r5 = r6.f140524c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L76
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r6.f140523b
                kotlin.text.DelimitedRangesSequence r4 = kotlin.text.DelimitedRangesSequence.this
                java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.d(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.h0(r4)
                r0.<init>(r1, r4)
                r6.f140525d = r0
                r6.f140524c = r2
                goto L9b
            L76:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f140523b
                kotlin.ranges.IntRange r4 = kotlin.ranges.RangesKt.B(r4, r2)
                r6.f140525d = r4
                int r2 = r2 + r0
                r6.f140523b = r2
                if (r0 != 0) goto L98
                r1 = r3
            L98:
                int r2 = r2 + r1
                r6.f140524c = r2
            L9b:
                r6.f140522a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence.AnonymousClass1.a():void");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntRange next() {
            if (this.f140522a == -1) {
                a();
            }
            if (this.f140522a == 0) {
                throw new NoSuchElementException();
            }
            IntRange intRange = this.f140525d;
            Intrinsics.checkNotNull(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f140525d = null;
            this.f140522a = -1;
            return intRange;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f140522a == -1) {
                a();
            }
            return this.f140522a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public DelimitedRangesSequence(CharSequence input, int i3, int i4, Function2 getNextMatch) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(getNextMatch, "getNextMatch");
        this.f140518a = input;
        this.f140519b = i3;
        this.f140520c = i4;
        this.f140521d = getNextMatch;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new AnonymousClass1();
    }
}
