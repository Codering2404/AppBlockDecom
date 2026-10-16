package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;

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
public final class ChannelSegment<E> extends Segment<ChannelSegment<E>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BufferedChannel f141134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f141135g;

    public ChannelSegment(long j3, ChannelSegment channelSegment, BufferedChannel bufferedChannel, int i3) {
        super(j3, channelSegment, i3);
        this.f141134f = bufferedChannel;
        this.f141135g = new AtomicReferenceArray(BufferedChannelKt.f141105b * 2);
    }

    private final void E(int i3, Object obj) {
        z().set(i3 * 2, obj);
    }

    private final /* synthetic */ AtomicReferenceArray z() {
        return this.f141135g;
    }

    public final Object A(int i3) {
        return z().get(i3 * 2);
    }

    public final Object B(int i3) {
        return z().get((i3 * 2) + 1);
    }

    public final void C(int i3, boolean z2) {
        if (z2) {
            y().H1((this.f142482c * ((long) BufferedChannelKt.f141105b)) + ((long) i3));
        }
        t();
    }

    public final Object D(int i3) {
        Object objA = A(i3);
        w(i3);
        return objA;
    }

    public final void F(int i3, Object obj) {
        z().set((i3 * 2) + 1, obj);
    }

    public final void G(int i3, Object obj) {
        E(i3, obj);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int r() {
        return BufferedChannelKt.f141105b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        w(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        r4 = y().f141077b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        if (r4 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
    
        kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.internal.Segment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void s(int r4, java.lang.Throwable r5, kotlin.coroutines.CoroutineContext r6) {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f141105b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.A(r4)
        Le:
            java.lang.Object r1 = r3.B(r4)
            boolean r2 = r1 instanceof kotlinx.coroutines.Waiter
            if (r2 != 0) goto L73
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r2 == 0) goto L1b
            goto L73
        L1b:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            if (r1 == r2) goto L62
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
            if (r1 != r2) goto L28
            goto L62
        L28:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r1 == r2) goto Le
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.f()
            if (r1 == r4) goto L99
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.f141107d
            if (r1 != r4) goto L40
            goto L99
        L40:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            if (r1 != r4) goto L47
            goto L99
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unexpected state: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L62:
            r3.w(r4)
            if (r0 == 0) goto L99
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.y()
            kotlin.jvm.functions.Function1 r4 = r4.f141077b
            if (r4 == 0) goto L99
            kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r4, r5, r6)
            return
        L73:
            if (r0 == 0) goto L7a
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            goto L7e
        L7a:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
        L7e:
            boolean r1 = r3.v(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.w(r4)
            r1 = r0 ^ 1
            r3.C(r4, r1)
            if (r0 == 0) goto L99
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.y()
            kotlin.jvm.functions.Function1 r4 = r4.f141077b
            if (r4 == 0) goto L99
            kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r4, r5, r6)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelSegment.s(int, java.lang.Throwable, kotlin.coroutines.CoroutineContext):void");
    }

    public final boolean v(int i3, Object obj, Object obj2) {
        return d.a(z(), (i3 * 2) + 1, obj, obj2);
    }

    public final void w(int i3) {
        E(i3, null);
    }

    public final Object x(int i3, Object obj) {
        return z().getAndSet((i3 * 2) + 1, obj);
    }

    public final BufferedChannel y() {
        BufferedChannel bufferedChannel = this.f141134f;
        Intrinsics.checkNotNull(bufferedChannel);
        return bufferedChannel;
    }
}
