package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

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
public final class ComposableSingletons$ScaffoldKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ScaffoldKt f12504a = new ComposableSingletons$ScaffoldKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function2 f12505b = ComposableLambdaKt.c(20777959, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(20777959, i3, -1, "androidx.compose.material.ComposableSingletons$ScaffoldKt.lambda-1.<anonymous> (Scaffold.kt:186)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function2 f12506c = ComposableLambdaKt.c(-212732681, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-212732681, i3, -1, "androidx.compose.material.ComposableSingletons$ScaffoldKt.lambda-2.<anonymous> (Scaffold.kt:187)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function3 f12507d = ComposableLambdaKt.c(2086581188, false, new Function3<SnackbarHostState, Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-3$1
        public final void c(SnackbarHostState snackbarHostState, Composer composer, int i3) {
            if ((i3 & 6) == 0) {
                i3 |= composer.Z(snackbarHostState) ? 4 : 2;
            }
            if ((i3 & 19) == 18 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(2086581188, i3, -1, "androidx.compose.material.ComposableSingletons$ScaffoldKt.lambda-3.<anonymous> (Scaffold.kt:188)");
            }
            SnackbarHostKt.b(snackbarHostState, null, null, composer, i3 & 14, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            c((SnackbarHostState) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.f139807a;
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Function2 f12508e = ComposableLambdaKt.c(10046167, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(10046167, i3, -1, "androidx.compose.material.ComposableSingletons$ScaffoldKt.lambda-4.<anonymous> (Scaffold.kt:189)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Function2 f12509f = ComposableLambdaKt.c(2069405901, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(2069405901, i3, -1, "androidx.compose.material.ComposableSingletons$ScaffoldKt.lambda-5.<anonymous> (Scaffold.kt:314)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Function2 f12510g = ComposableLambdaKt.c(-231850563, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-231850563, i3, -1, "androidx.compose.material.ComposableSingletons$ScaffoldKt.lambda-6.<anonymous> (Scaffold.kt:315)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Function3 f12511h = ComposableLambdaKt.c(-147687984, false, new Function3<SnackbarHostState, Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-7$1
        public final void c(SnackbarHostState snackbarHostState, Composer composer, int i3) {
            if ((i3 & 6) == 0) {
                i3 |= composer.Z(snackbarHostState) ? 4 : 2;
            }
            if ((i3 & 19) == 18 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-147687984, i3, -1, "androidx.compose.material.ComposableSingletons$ScaffoldKt.lambda-7.<anonymous> (Scaffold.kt:316)");
            }
            SnackbarHostKt.b(snackbarHostState, null, null, composer, i3 & 14, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            c((SnackbarHostState) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.f139807a;
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Function2 f12512i = ComposableLambdaKt.c(-900670499, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-900670499, i3, -1, "androidx.compose.material.ComposableSingletons$ScaffoldKt.lambda-8.<anonymous> (Scaffold.kt:317)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    public final Function2 a() {
        return f12505b;
    }

    public final Function2 b() {
        return f12506c;
    }

    public final Function3 c() {
        return f12507d;
    }

    public final Function2 d() {
        return f12508e;
    }

    public final Function2 e() {
        return f12509f;
    }

    public final Function2 f() {
        return f12510g;
    }

    public final Function3 g() {
        return f12511h;
    }

    public final Function2 h() {
        return f12512i;
    }
}
