package androidx.compose.runtime.saveable;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
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
final class SaveableStateHolderImpl implements SaveableStateHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f24861e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Saver f24862f = SaverKt.a(new Function2<SaverScope, SaveableStateHolderImpl, Map<Object, Map<String, ? extends List<? extends Object>>>>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Map invoke(SaverScope saverScope, SaveableStateHolderImpl saveableStateHolderImpl) {
            return saveableStateHolderImpl.i();
        }
    }, new Function1<Map<Object, Map<String, ? extends List<? extends Object>>>, SaveableStateHolderImpl>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final SaveableStateHolderImpl invoke(Map map) {
            return new SaveableStateHolderImpl(map);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f24863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableScatterMap f24864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SaveableStateRegistry f24865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f24866d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return SaveableStateHolderImpl.f24862f;
        }

        private Companion() {
        }
    }

    public SaveableStateHolderImpl(Map map) {
        this.f24863a = map;
        this.f24864b = ScatterMapKt.c();
        this.f24866d = new Function1<Object, Boolean>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$canBeSaved$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj) {
                SaveableStateRegistry saveableStateRegistryH = this.f24875a.h();
                return Boolean.valueOf(saveableStateRegistryH != null ? saveableStateRegistryH.a(obj) : true);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map i() {
        /*
            r17 = this;
            r0 = r17
            java.util.Map r1 = r0.f24863a
            androidx.collection.MutableScatterMap r2 = r0.f24864b
            java.lang.Object[] r3 = r2.f3109b
            java.lang.Object[] r4 = r2.f3110c
            long[] r2 = r2.f3108a
            int r5 = r2.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L4f
            r6 = 0
            r7 = r6
        L13:
            r8 = r2[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L4a
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L2d:
            if (r12 >= r10) goto L48
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L44
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r4[r13]
            androidx.compose.runtime.saveable.SaveableStateRegistry r13 = (androidx.compose.runtime.saveable.SaveableStateRegistry) r13
            r0.j(r13, r1, r14)
        L44:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L2d
        L48:
            if (r10 != r11) goto L4f
        L4a:
            if (r7 == r5) goto L4f
            int r7 = r7 + 1
            goto L13
        L4f:
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L56
            r1 = 0
        L56:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.saveable.SaveableStateHolderImpl.i():java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(SaveableStateRegistry saveableStateRegistry, Map map, Object obj) {
        Map mapE = saveableStateRegistry.e();
        if (mapE.isEmpty()) {
            map.remove(obj);
        } else {
            map.put(obj, mapE);
        }
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void c(Object obj) {
        if (this.f24864b.u(obj) == null) {
            this.f24863a.remove(obj);
        }
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void d(final Object obj, Function2 function2, Composer composer, int i3) {
        composer.a0(-1198538093);
        if (ComposerKt.M()) {
            ComposerKt.U(-1198538093, i3, -1, "androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider (SaveableStateHolder.kt:69)");
        }
        composer.O(207, obj);
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            if (!((Boolean) this.f24866d.invoke(obj)).booleanValue()) {
                throw new IllegalArgumentException(("Type of the key " + obj + " is not supported. On Android you can only use types which can be stored inside the Bundle.").toString());
            }
            objG = SaveableStateRegistryKt.a((Map) this.f24863a.get(obj), this.f24866d);
            composer.w(objG);
        }
        final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) objG;
        CompositionLocalKt.b(SaveableStateRegistryKt.e().d(saveableStateRegistry), function2, composer, (i3 & 112) | ProvidedValue.f24012i);
        Unit unit = Unit.f139807a;
        boolean zI = composer.I(this) | composer.I(obj) | composer.I(saveableStateRegistry);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    boolean zB = this.f24869a.f24864b.b(obj);
                    Object obj2 = obj;
                    if (zB) {
                        throw new IllegalArgumentException(("Key " + obj2 + " was used multiple times ").toString());
                    }
                    this.f24869a.f24863a.remove(obj);
                    this.f24869a.f24864b.x(obj, saveableStateRegistry);
                    final SaveableStateHolderImpl saveableStateHolderImpl = this.f24869a;
                    final Object obj3 = obj;
                    final SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                    return new DisposableEffectResult() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$1$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Object objU = saveableStateHolderImpl.f24864b.u(obj3);
                            SaveableStateRegistry saveableStateRegistry3 = saveableStateRegistry2;
                            if (objU == saveableStateRegistry3) {
                                SaveableStateHolderImpl saveableStateHolderImpl2 = saveableStateHolderImpl;
                                saveableStateHolderImpl2.j(saveableStateRegistry3, saveableStateHolderImpl2.f24863a, obj3);
                            }
                        }
                    };
                }
            };
            composer.w(objG2);
        }
        EffectsKt.c(unit, (Function1) objG2, composer, 6);
        composer.E();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
    }

    public final SaveableStateRegistry h() {
        return this.f24865c;
    }

    public final void k(SaveableStateRegistry saveableStateRegistry) {
        this.f24865c = saveableStateRegistry;
    }

    public /* synthetic */ SaveableStateHolderImpl(Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new LinkedHashMap() : map);
    }
}
