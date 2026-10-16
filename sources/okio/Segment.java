package okio;

import com.facebook.internal.Utility;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class Segment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f145103h = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f145104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f145105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f145106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f145107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f145108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Segment f145109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Segment f145110g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Segment() {
        this.f145104a = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        this.f145108e = true;
        this.f145107d = false;
    }

    public final void a() {
        int i3;
        Segment segment = this.f145110g;
        if (segment == this) {
            throw new IllegalStateException("cannot compact");
        }
        Intrinsics.checkNotNull(segment);
        if (segment.f145108e) {
            int i4 = this.f145106c - this.f145105b;
            Segment segment2 = this.f145110g;
            Intrinsics.checkNotNull(segment2);
            int i5 = 8192 - segment2.f145106c;
            Segment segment3 = this.f145110g;
            Intrinsics.checkNotNull(segment3);
            if (segment3.f145107d) {
                i3 = 0;
            } else {
                Segment segment4 = this.f145110g;
                Intrinsics.checkNotNull(segment4);
                i3 = segment4.f145105b;
            }
            if (i4 > i5 + i3) {
                return;
            }
            Segment segment5 = this.f145110g;
            Intrinsics.checkNotNull(segment5);
            g(segment5, i4);
            b();
            SegmentPool.b(this);
        }
    }

    public final Segment b() {
        Segment segment = this.f145109f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.f145110g;
        Intrinsics.checkNotNull(segment2);
        segment2.f145109f = this.f145109f;
        Segment segment3 = this.f145109f;
        Intrinsics.checkNotNull(segment3);
        segment3.f145110g = this.f145110g;
        this.f145109f = null;
        this.f145110g = null;
        return segment;
    }

    public final Segment c(Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.f145110g = this;
        segment.f145109f = this.f145109f;
        Segment segment2 = this.f145109f;
        Intrinsics.checkNotNull(segment2);
        segment2.f145110g = segment;
        this.f145109f = segment;
        return segment;
    }

    public final Segment d() {
        this.f145107d = true;
        return new Segment(this.f145104a, this.f145105b, this.f145106c, true, false);
    }

    public final Segment e(int i3) {
        Segment segmentC;
        if (i3 <= 0 || i3 > this.f145106c - this.f145105b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i3 >= 1024) {
            segmentC = d();
        } else {
            segmentC = SegmentPool.c();
            byte[] bArr = this.f145104a;
            byte[] bArr2 = segmentC.f145104a;
            int i4 = this.f145105b;
            ArraysKt.copyInto$default(bArr, bArr2, 0, i4, i4 + i3, 2, (Object) null);
        }
        segmentC.f145106c = segmentC.f145105b + i3;
        this.f145105b += i3;
        Segment segment = this.f145110g;
        Intrinsics.checkNotNull(segment);
        segment.c(segmentC);
        return segmentC;
    }

    public final Segment f() {
        byte[] bArr = this.f145104a;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return new Segment(bArrCopyOf, this.f145105b, this.f145106c, false, true);
    }

    public final void g(Segment sink, int i3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.f145108e) {
            throw new IllegalStateException("only owner can write");
        }
        int i4 = sink.f145106c;
        if (i4 + i3 > 8192) {
            if (sink.f145107d) {
                throw new IllegalArgumentException();
            }
            int i5 = sink.f145105b;
            if ((i4 + i3) - i5 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f145104a;
            ArraysKt.copyInto$default(bArr, bArr, 0, i5, i4, 2, (Object) null);
            sink.f145106c -= sink.f145105b;
            sink.f145105b = 0;
        }
        byte[] bArr2 = this.f145104a;
        byte[] bArr3 = sink.f145104a;
        int i6 = sink.f145106c;
        int i7 = this.f145105b;
        ArraysKt.copyInto(bArr2, bArr3, i6, i7, i7 + i3);
        sink.f145106c += i3;
        this.f145105b += i3;
    }

    public Segment(byte[] data, int i3, int i4, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f145104a = data;
        this.f145105b = i3;
        this.f145106c = i4;
        this.f145107d = z2;
        this.f145108e = z3;
    }
}
