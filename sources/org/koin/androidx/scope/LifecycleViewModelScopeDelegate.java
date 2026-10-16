package org.koin.androidx.scope;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.scope.Scope;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class LifecycleViewModelScopeDelegate implements ReadOnlyProperty<LifecycleOwner, Scope> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ComponentActivity f145724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Koin f145725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f145726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Scope f145727d;

    /* JADX INFO: renamed from: org.koin.androidx.scope.LifecycleViewModelScopeDelegate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<Koin, Scope> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f145728a;

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Scope invoke(Koin k3) {
            Intrinsics.checkNotNullParameter(k3, "k");
            return Koin.c(k3, KoinScopeComponentKt.d(this.f145728a).getValue(), KoinScopeComponentKt.d(this.f145728a), null, 4, null);
        }
    }

    /* JADX INFO: renamed from: org.koin.androidx.scope.LifecycleViewModelScopeDelegate$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class AnonymousClass2 implements DefaultLifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScopeHandlerViewModel f145729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LifecycleViewModelScopeDelegate f145730b;

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onCreate(LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            if (this.f145729a.getScope() == null) {
                this.f145729a.y0((Scope) this.f145730b.f145726c.invoke(this.f145730b.f145725b));
            }
            this.f145730b.f145727d = this.f145729a.getScope();
        }
    }

    private final boolean g(LifecycleOwner lifecycleOwner) {
        return lifecycleOwner.getLifecycle().getCurrentState().b(Lifecycle.State.f39949c);
    }

    @Override // kotlin.properties.ReadOnlyProperty
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Scope a(LifecycleOwner lifecycleOwner, KProperty property) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, cJfnYMIyomoWf.DWISNMBxMBjany);
        Intrinsics.checkNotNullParameter(property, "property");
        Scope scope = this.f145727d;
        if (scope != null) {
            Intrinsics.checkNotNull(scope);
            return scope;
        }
        if (!g(lifecycleOwner)) {
            throw new IllegalStateException(("can't get Scope for " + this.f145724a + " - LifecycleOwner is not Active").toString());
        }
        Scope scopeI = this.f145725b.i(KoinScopeComponentKt.d(this.f145724a).getValue());
        if (scopeI == null) {
            scopeI = (Scope) this.f145726c.invoke(this.f145725b);
        }
        this.f145727d = scopeI;
        Logger loggerF = this.f145725b.f();
        String str = "got scope: " + this.f145727d + " for " + this.f145724a;
        Level level = Level.DEBUG;
        if (loggerF.c(level)) {
            loggerF.a(level, str);
        }
        Scope scope2 = this.f145727d;
        Intrinsics.checkNotNull(scope2);
        return scope2;
    }
}
