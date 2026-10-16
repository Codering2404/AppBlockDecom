package cz.mobilesoft.appblock;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.crashlytics.internal.metadata.rSN.xSRx;
import cz.mobilesoft.appblock.service.LockAccessibilityService;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl;
import cz.mobilesoft.widgets.WidgetApplication;
import cz.mobilesoft.widgets.WidgetDataProvider;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class AppBlockApplication extends LockieApplication implements WidgetApplication {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f93831m = new Companion(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f93832n = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f93833l = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AppBlockApplication.z(this.f93934a);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        LockieApplication.f95364j = LockAccessibilityService.class;
        LockieApplication.f95358c = "7.21.1";
        LockieApplication.f95359d = 579;
        LockieApplication.f95360f = "cz.mobilesoft.appblock";
    }

    public static final Intent y(Context context) {
        return new Intent(context, (Class<?>) MainActivity.class);
    }

    public static final WidgetDataProviderImpl z(AppBlockApplication appBlockApplication) {
        return new WidgetDataProviderImpl(appBlockApplication, MainActivity.class);
    }

    @Override // cz.mobilesoft.widgets.WidgetApplication
    public WidgetDataProvider a() {
        return (WidgetDataProvider) this.f93833l.getValue();
    }

    @Override // cz.mobilesoft.coreblock.LockieApplication
    public List j() {
        return CollectionsKt.listOf(PermissionActivity.class);
    }

    @Override // cz.mobilesoft.coreblock.LockieApplication
    public List k() {
        return CollectionsKt.listOf(MainActivity.class);
    }

    @Override // cz.mobilesoft.coreblock.LockieApplication, android.app.Application
    public void onCreate() throws IllegalAccessException, InvocationTargetException {
        xSRx.SOE.invoke(null, this);
    }
}
