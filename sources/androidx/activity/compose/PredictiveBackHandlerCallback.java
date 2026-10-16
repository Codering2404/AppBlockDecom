package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class PredictiveBackHandlerCallback extends OnBackPressedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CoroutineScope f474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function2 f475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnBackInstance f476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f477d;

    public PredictiveBackHandlerCallback(boolean z2, CoroutineScope coroutineScope, Function2 function2) {
        super(z2);
        this.f474a = coroutineScope;
        this.f475b = function2;
    }

    public final void d(Function2 function2) {
        this.f475b = function2;
    }

    public final void e(boolean z2) {
        OnBackInstance onBackInstance;
        if (!z2 && !this.f477d && isEnabled() && (onBackInstance = this.f476c) != null) {
            onBackInstance.a();
        }
        setEnabled(z2);
    }

    public final void f(CoroutineScope coroutineScope) {
        this.f474a = coroutineScope;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackCancelled() {
        super.handleOnBackCancelled();
        OnBackInstance onBackInstance = this.f476c;
        if (onBackInstance != null) {
            onBackInstance.a();
        }
        OnBackInstance onBackInstance2 = this.f476c;
        if (onBackInstance2 != null) {
            onBackInstance2.f(false);
        }
        this.f477d = false;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        OnBackInstance onBackInstance = this.f476c;
        if (onBackInstance != null && !onBackInstance.d()) {
            onBackInstance.a();
            this.f476c = null;
        }
        if (this.f476c == null) {
            this.f476c = new OnBackInstance(this.f474a, false, this.f475b, this);
        }
        OnBackInstance onBackInstance2 = this.f476c;
        if (onBackInstance2 != null) {
            onBackInstance2.b();
        }
        OnBackInstance onBackInstance3 = this.f476c;
        if (onBackInstance3 != null) {
            onBackInstance3.f(false);
        }
        this.f477d = false;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackProgressed(BackEventCompat backEventCompat) {
        super.handleOnBackProgressed(backEventCompat);
        OnBackInstance onBackInstance = this.f476c;
        if (onBackInstance != null) {
            ChannelResult.b(onBackInstance.e(backEventCompat));
        }
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackStarted(BackEventCompat backEventCompat) {
        super.handleOnBackStarted(backEventCompat);
        OnBackInstance onBackInstance = this.f476c;
        if (onBackInstance != null) {
            onBackInstance.a();
        }
        if (isEnabled()) {
            this.f476c = new OnBackInstance(this.f474a, true, this.f475b, this);
        }
        this.f477d = true;
    }
}
