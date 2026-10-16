package okio;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class FileMetadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f145025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f145026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f145027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f145028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f145029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Long f145030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Long f145031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f145032h;

    public FileMetadata(boolean z2, boolean z3, Path path, Long l3, Long l4, Long l5, Long l6, Map extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.f145025a = z2;
        this.f145026b = z3;
        this.f145027c = path;
        this.f145028d = l3;
        this.f145029e = l4;
        this.f145030f = l5;
        this.f145031g = l6;
        this.f145032h = MapsKt.toMap(extras);
    }

    public static /* synthetic */ FileMetadata b(FileMetadata fileMetadata, boolean z2, boolean z3, Path path, Long l3, Long l4, Long l5, Long l6, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = fileMetadata.f145025a;
        }
        if ((i3 & 2) != 0) {
            z3 = fileMetadata.f145026b;
        }
        if ((i3 & 4) != 0) {
            path = fileMetadata.f145027c;
        }
        if ((i3 & 8) != 0) {
            l3 = fileMetadata.f145028d;
        }
        if ((i3 & 16) != 0) {
            l4 = fileMetadata.f145029e;
        }
        if ((i3 & 32) != 0) {
            l5 = fileMetadata.f145030f;
        }
        if ((i3 & 64) != 0) {
            l6 = fileMetadata.f145031g;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            map = fileMetadata.f145032h;
        }
        Long l7 = l6;
        Map map2 = map;
        Long l8 = l4;
        Long l9 = l5;
        return fileMetadata.a(z2, z3, path, l3, l8, l9, l7, map2);
    }

    public final FileMetadata a(boolean z2, boolean z3, Path path, Long l3, Long l4, Long l5, Long l6, Map extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        return new FileMetadata(z2, z3, path, l3, l4, l5, l6, extras);
    }

    public final Long c() {
        return this.f145030f;
    }

    public final Long d() {
        return this.f145028d;
    }

    public final Path e() {
        return this.f145027c;
    }

    public final boolean f() {
        return this.f145026b;
    }

    public final boolean g() {
        return this.f145025a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f145025a) {
            arrayList.add("isRegularFile");
        }
        if (this.f145026b) {
            arrayList.add("isDirectory");
        }
        if (this.f145028d != null) {
            arrayList.add("byteCount=" + this.f145028d);
        }
        if (this.f145029e != null) {
            arrayList.add("createdAt=" + this.f145029e);
        }
        if (this.f145030f != null) {
            arrayList.add("lastModifiedAt=" + this.f145030f);
        }
        if (this.f145031g != null) {
            arrayList.add("lastAccessedAt=" + this.f145031g);
        }
        if (!this.f145032h.isEmpty()) {
            arrayList.add("extras=" + this.f145032h);
        }
        return CollectionsKt.joinToString$default(arrayList, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }

    public /* synthetic */ FileMetadata(boolean z2, boolean z3, Path path, Long l3, Long l4, Long l5, Long l6, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? null : path, (i3 & 8) != 0 ? null : l3, (i3 & 16) != 0 ? null : l4, (i3 & 32) != 0 ? null : l5, (i3 & 64) != 0 ? null : l6, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? MapsKt.emptyMap() : map);
    }
}
