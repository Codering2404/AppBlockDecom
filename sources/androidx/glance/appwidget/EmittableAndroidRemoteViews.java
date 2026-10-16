package androidx.glance.appwidget;

import android.widget.RemoteViews;
import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class EmittableAndroidRemoteViews extends EmittableWithChildren {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GlanceModifier f37883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RemoteViews f37885f;

    public EmittableAndroidRemoteViews() {
        super(0, false, 3, null);
        this.f37883d = GlanceModifier.f37605a;
        this.f37884e = -1;
    }

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f37883d;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f37883d = glanceModifier;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableAndroidRemoteViews emittableAndroidRemoteViews = new EmittableAndroidRemoteViews();
        emittableAndroidRemoteViews.b(a());
        if (this.f37885f != null) {
            emittableAndroidRemoteViews.k(i());
        }
        emittableAndroidRemoteViews.f37884e = this.f37884e;
        List listD = emittableAndroidRemoteViews.d();
        List listD2 = d();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listD2, 10));
        Iterator it = listD2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Emittable) it.next()).copy());
        }
        listD.addAll(arrayList);
        return emittableAndroidRemoteViews;
    }

    public final int h() {
        return this.f37884e;
    }

    public final RemoteViews i() {
        RemoteViews remoteViews = this.f37885f;
        if (remoteViews != null) {
            return remoteViews;
        }
        Intrinsics.throwUninitializedPropertyAccessException("remoteViews");
        return null;
    }

    public final void j(int i3) {
        this.f37884e = i3;
    }

    public final void k(RemoteViews remoteViews) {
        this.f37885f = remoteViews;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AndroidRemoteViews(modifier=");
        sb.append(a());
        sb.append(", containerViewId=");
        sb.append(this.f37884e);
        sb.append(", remoteViews=");
        sb.append(this.f37885f != null ? i() : null);
        sb.append(", children=[\n");
        sb.append(c());
        sb.append("\n])");
        return sb.toString();
    }
}
