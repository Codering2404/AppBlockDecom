package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class LazySaveableStateHolder implements SaveableStateRegistry, SaveableStateHolder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f8232d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SaveableStateRegistry f8233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SaveableStateHolder f8234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableScatterSet f8235c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a(final SaveableStateRegistry saveableStateRegistry, final SaveableStateHolder saveableStateHolder) {
            return SaverKt.a(new Function2<SaverScope, LazySaveableStateHolder, Map<String, ? extends List<? extends Object>>>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Map invoke(SaverScope saverScope, LazySaveableStateHolder lazySaveableStateHolder) {
                    Map mapE = lazySaveableStateHolder.e();
                    if (mapE.isEmpty()) {
                        return null;
                    }
                    return mapE;
                }
            }, new Function1<Map<String, ? extends List<? extends Object>>, LazySaveableStateHolder>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final LazySaveableStateHolder invoke(Map map) {
                    return new LazySaveableStateHolder(saveableStateRegistry, map, saveableStateHolder);
                }
            });
        }

        private Companion() {
        }
    }

    public LazySaveableStateHolder(SaveableStateRegistry saveableStateRegistry, SaveableStateHolder saveableStateHolder) {
        this.f8233a = saveableStateRegistry;
        this.f8234b = saveableStateHolder;
        this.f8235c = ScatterSetKt.a();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean a(Object obj) {
        return this.f8233a.a(obj);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public SaveableStateRegistry.Entry b(String str, Function0 function0) {
        return this.f8233a.b(str, function0);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void c(Object obj) {
        this.f8234b.c(obj);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void d(final Object obj, Function2 function2, Composer composer, int i3) {
        composer.a0(-697180401);
        if (ComposerKt.M()) {
            ComposerKt.U(-697180401, i3, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:74)");
        }
        int i4 = i3 & 14;
        this.f8234b.d(obj, function2, composer, i3 & 126);
        boolean zI = composer.I(this) | composer.I(obj);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    this.f8240a.f8235c.v(obj);
                    final LazySaveableStateHolder lazySaveableStateHolder = this.f8240a;
                    final Object obj2 = obj;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            lazySaveableStateHolder.f8235c.y(obj2);
                        }
                    };
                }
            };
            composer.w(objG);
        }
        EffectsKt.c(obj, (Function1) objG, composer, i4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map e() {
        /*
            r14 = this;
            androidx.collection.MutableScatterSet r0 = r14.f8235c
            java.lang.Object[] r1 = r0.f3116b
            long[] r0 = r0.f3115a
            int r2 = r0.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L47
            r3 = 0
            r4 = r3
        Ld:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L42
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L27:
            if (r9 >= r7) goto L40
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L3c
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            androidx.compose.runtime.saveable.SaveableStateHolder r11 = r14.f8234b
            r11.c(r10)
        L3c:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L27
        L40:
            if (r7 != r8) goto L47
        L42:
            if (r4 == r2) goto L47
            int r4 = r4 + 1
            goto Ld
        L47:
            androidx.compose.runtime.saveable.SaveableStateRegistry r0 = r14.f8233a
            java.util.Map r0 = r0.e()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.e():java.util.Map");
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object f(String str) {
        return this.f8233a.f(str);
    }

    public LazySaveableStateHolder(final SaveableStateRegistry saveableStateRegistry, Map map, SaveableStateHolder saveableStateHolder) {
        this(SaveableStateRegistryKt.a(map, new Function1<Object, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj) {
                SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                return Boolean.valueOf(saveableStateRegistry2 != null ? saveableStateRegistry2.a(obj) : true);
            }
        }), saveableStateHolder);
    }
}
