package okio.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;

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
public final class ZipEntry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f145176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f145177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f145178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f145179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f145180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f145181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f145182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Long f145183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f145184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f145185j;

    public ZipEntry(Path canonicalPath, boolean z2, String comment, long j3, long j4, long j5, int i3, Long l3, long j6) {
        Intrinsics.checkNotNullParameter(canonicalPath, "canonicalPath");
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.f145176a = canonicalPath;
        this.f145177b = z2;
        this.f145178c = comment;
        this.f145179d = j3;
        this.f145180e = j4;
        this.f145181f = j5;
        this.f145182g = i3;
        this.f145183h = l3;
        this.f145184i = j6;
        this.f145185j = new ArrayList();
    }

    public final Path a() {
        return this.f145176a;
    }

    public final List b() {
        return this.f145185j;
    }

    public final long c() {
        return this.f145180e;
    }

    public final int d() {
        return this.f145182g;
    }

    public final Long e() {
        return this.f145183h;
    }

    public final long f() {
        return this.f145184i;
    }

    public final long g() {
        return this.f145181f;
    }

    public final boolean h() {
        return this.f145177b;
    }

    public /* synthetic */ ZipEntry(Path path, boolean z2, String str, long j3, long j4, long j5, int i3, Long l3, long j6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(path, (i4 & 2) != 0 ? false : z2, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? -1L : j3, (i4 & 16) != 0 ? -1L : j4, (i4 & 32) != 0 ? -1L : j5, (i4 & 64) != 0 ? -1 : i3, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : l3, (i4 & Function.MAX_NARGS) != 0 ? -1L : j6);
    }
}
