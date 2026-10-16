package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LazyLayoutItemContentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SaveableStateHolder f8102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f8103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableScatterMap f8104c = ScatterMapKt.c();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class CachedItemContent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f8105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f8106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f8107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Function2 f8108d;

        public CachedItemContent(int i3, Object obj, Object obj2) {
            this.f8105a = obj;
            this.f8106b = obj2;
            this.f8107c = i3;
        }

        private final Function2 c() {
            final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = LazyLayoutItemContentFactory.this;
            return ComposableLambdaKt.c(1403994769, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer, int i3) {
                    Composer composer2;
                    if (!composer.r((i3 & 3) != 2, i3 & 1)) {
                        composer.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1403994769, i3, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:87)");
                    }
                    LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) lazyLayoutItemContentFactory.d().invoke();
                    int iF = this.f();
                    if ((iF >= lazyLayoutItemProvider.a() || !Intrinsics.areEqual(lazyLayoutItemProvider.d(iF), this.g())) && (iF = lazyLayoutItemProvider.c(this.g())) != -1) {
                        this.f8107c = iF;
                    }
                    int i4 = iF;
                    if (i4 != -1) {
                        composer.a0(-660404355);
                        composer2 = composer;
                        LazyLayoutItemContentFactoryKt.a(lazyLayoutItemProvider, StableValue.a(lazyLayoutItemContentFactory.f8102a), i4, StableValue.a(this.g()), composer2, 0);
                        composer2.U();
                    } else {
                        composer2 = composer;
                        composer2.a0(-660169871);
                        composer2.U();
                    }
                    Object objG = this.g();
                    boolean zI = composer2.I(this);
                    final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = this;
                    Object objG2 = composer2.G();
                    if (zI || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent2 = cachedItemContent;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$1$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        cachedItemContent2.f8108d = null;
                                    }
                                };
                            }
                        };
                        composer2.w(objG2);
                    }
                    EffectsKt.c(objG, (Function1) objG2, composer2, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            });
        }

        public final Function2 d() {
            Function2 function2 = this.f8108d;
            if (function2 != null) {
                return function2;
            }
            Function2 function2C = c();
            this.f8108d = function2C;
            return function2C;
        }

        public final Object e() {
            return this.f8106b;
        }

        public final int f() {
            return this.f8107c;
        }

        public final Object g() {
            return this.f8105a;
        }
    }

    public LazyLayoutItemContentFactory(SaveableStateHolder saveableStateHolder, Function0 function0) {
        this.f8102a = saveableStateHolder;
        this.f8103b = function0;
    }

    public final Function2 b(int i3, Object obj, Object obj2) {
        CachedItemContent cachedItemContent = (CachedItemContent) this.f8104c.e(obj);
        if (cachedItemContent != null && cachedItemContent.f() == i3 && Intrinsics.areEqual(cachedItemContent.e(), obj2)) {
            return cachedItemContent.d();
        }
        CachedItemContent cachedItemContent2 = new CachedItemContent(i3, obj, obj2);
        this.f8104c.x(obj, cachedItemContent2);
        return cachedItemContent2.d();
    }

    public final Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        CachedItemContent cachedItemContent = (CachedItemContent) this.f8104c.e(obj);
        if (cachedItemContent != null) {
            return cachedItemContent.e();
        }
        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.f8103b.invoke();
        int iC = lazyLayoutItemProvider.c(obj);
        if (iC != -1) {
            return lazyLayoutItemProvider.f(iC);
        }
        return null;
    }

    public final Function0 d() {
        return this.f8103b;
    }
}
