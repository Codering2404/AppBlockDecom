package androidx.navigation;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.navigation.ActivityNavigator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

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
@NavDestinationDsl
@Metadata
public final class ActivityNavigatorDestinationBuilder extends NavDestinationBuilder<ActivityNavigator.Destination> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f48752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f48753j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private KClass f48754k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f48755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Uri f48756m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f48757n;

    @Override // androidx.navigation.NavDestinationBuilder
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ActivityNavigator.Destination b() {
        ActivityNavigator.Destination destination = (ActivityNavigator.Destination) super.b();
        destination.Q(this.f48753j);
        KClass kClass = this.f48754k;
        if (kClass != null) {
            destination.N(new ComponentName(this.f48752i, (Class<?>) JvmClassMappingKt.a(kClass)));
        }
        destination.M(this.f48755l);
        destination.O(this.f48756m);
        destination.P(this.f48757n);
        return destination;
    }
}
