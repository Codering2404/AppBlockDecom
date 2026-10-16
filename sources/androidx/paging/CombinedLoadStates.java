package androidx.paging;

import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CombinedLoadStates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LoadState f49645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LoadState f49646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LoadState f49647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LoadStates f49648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LoadStates f49649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f49650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f49651g;

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CombinedLoadStates(androidx.paging.LoadState r2, androidx.paging.LoadState r3, androidx.paging.LoadState r4, androidx.paging.LoadStates r5, androidx.paging.LoadStates r6) {
        /*
            r1 = this;
            java.lang.String r0 = "refresh"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "prepend"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "append"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r1.<init>()
            r1.f49645a = r2
            r1.f49646b = r3
            r1.f49647c = r4
            r1.f49648d = r5
            r1.f49649e = r6
            boolean r2 = r5.h()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L35
            if (r6 == 0) goto L30
            boolean r2 = r6.h()
            goto L31
        L30:
            r2 = r4
        L31:
            if (r2 == 0) goto L35
            r2 = r4
            goto L36
        L35:
            r2 = r3
        L36:
            r1.f49650f = r2
            boolean r2 = r5.g()
            if (r2 != 0) goto L48
            if (r6 == 0) goto L45
            boolean r2 = r6.g()
            goto L46
        L45:
            r2 = r3
        L46:
            if (r2 == 0) goto L49
        L48:
            r3 = r4
        L49:
            r1.f49651g = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.CombinedLoadStates.<init>(androidx.paging.LoadState, androidx.paging.LoadState, androidx.paging.LoadState, androidx.paging.LoadStates, androidx.paging.LoadStates):void");
    }

    public final LoadState a() {
        return this.f49647c;
    }

    public final LoadStates b() {
        return this.f49649e;
    }

    public final LoadState c() {
        return this.f49646b;
    }

    public final LoadState d() {
        return this.f49645a;
    }

    public final LoadStates e() {
        return this.f49648d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CombinedLoadStates.class != obj.getClass()) {
            return false;
        }
        CombinedLoadStates combinedLoadStates = (CombinedLoadStates) obj;
        return Intrinsics.areEqual(this.f49645a, combinedLoadStates.f49645a) && Intrinsics.areEqual(this.f49646b, combinedLoadStates.f49646b) && Intrinsics.areEqual(this.f49647c, combinedLoadStates.f49647c) && Intrinsics.areEqual(this.f49648d, combinedLoadStates.f49648d) && Intrinsics.areEqual(this.f49649e, combinedLoadStates.f49649e);
    }

    public final boolean f() {
        return this.f49651g;
    }

    public final boolean g() {
        return this.f49650f;
    }

    public int hashCode() {
        int iHashCode = ((((((this.f49645a.hashCode() * 31) + this.f49646b.hashCode()) * 31) + this.f49647c.hashCode()) * 31) + this.f49648d.hashCode()) * 31;
        LoadStates loadStates = this.f49649e;
        return iHashCode + (loadStates != null ? loadStates.hashCode() : 0);
    }

    public String toString() {
        return "CombinedLoadStates(refresh=" + this.f49645a + ", prepend=" + this.f49646b + ", append=" + this.f49647c + ", source=" + this.f49648d + ", mediator=" + this.f49649e + ')';
    }

    public /* synthetic */ CombinedLoadStates(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadStates loadStates, LoadStates loadStates2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(loadState, loadState2, loadState3, loadStates, (i3 & 16) != 0 ? null : loadStates2);
    }
}
