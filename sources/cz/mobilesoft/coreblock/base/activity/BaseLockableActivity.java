package cz.mobilesoft.coreblock.base.activity;

import android.content.ComponentCallbacks;
import androidx.appcompat.app.AppCompatActivity;
import cz.mobilesoft.coreblock.service.passlock.PassCodeManager;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseLockableActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f96318a;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseLockableActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f96318a = LazyKt.a(lazyThreadSafetyMode, new Function0<PassCodeManager>() { // from class: cz.mobilesoft.coreblock.base.activity.BaseLockableActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(PassCodeManager.class), qualifier, objArr);
            }
        });
    }

    private final PassCodeManager V() {
        return (PassCodeManager) this.f96318a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(BaseLockableActivity baseLockableActivity) {
        baseLockableActivity.V().i(baseLockableActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(BaseLockableActivity baseLockableActivity) {
        baseLockableActivity.V().j(baseLockableActivity);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.coreblock.base.activity.i
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                BaseLockableActivity.W(this.f96330a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.coreblock.base.activity.h
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                BaseLockableActivity.X(this.f96329a);
            }
        });
    }
}
