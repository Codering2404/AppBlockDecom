package okio;

import kotlin.Metadata;
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
public final class PeekSource implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSource f145076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Buffer f145077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Segment f145078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f145079d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f145080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f145081g;

    public PeekSource(BufferedSource upstream) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.f145076a = upstream;
        Buffer bufferU = upstream.u();
        this.f145077b = bufferU;
        Segment segment = bufferU.f144986a;
        this.f145078c = segment;
        this.f145079d = segment != null ? segment.f145105b : -1;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f145080f = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3 == r4.f145105b) goto L15;
     */
    @Override // okio.Source
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long t2(okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L74
            boolean r3 = r8.f145080f
            if (r3 != 0) goto L6c
            okio.Segment r3 = r8.f145078c
            if (r3 == 0) goto L2b
            okio.Buffer r4 = r8.f145077b
            okio.Segment r4 = r4.f144986a
            if (r3 != r4) goto L23
            int r3 = r8.f145079d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.f145105b
            if (r3 != r4) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            okio.BufferedSource r0 = r8.f145076a
            long r1 = r8.f145081g
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.y(r1)
            if (r0 != 0) goto L3e
            r9 = -1
            return r9
        L3e:
            okio.Segment r0 = r8.f145078c
            if (r0 != 0) goto L51
            okio.Buffer r0 = r8.f145077b
            okio.Segment r0 = r0.f144986a
            if (r0 == 0) goto L51
            r8.f145078c = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.f145105b
            r8.f145079d = r0
        L51:
            okio.Buffer r0 = r8.f145077b
            long r0 = r0.size()
            long r2 = r8.f145081g
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            okio.Buffer r2 = r8.f145077b
            long r4 = r8.f145081g
            r3 = r9
            r2.j(r3, r4, r6)
            long r9 = r8.f145081g
            long r9 = r9 + r6
            r8.f145081g = r9
            return r6
        L6c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        L74:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "byteCount < 0: "
            r9.append(r0)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.PeekSource.t2(okio.Buffer, long):long");
    }

    @Override // okio.Source
    public Timeout v() {
        return this.f145076a.v();
    }
}
