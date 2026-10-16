package androidx.navigation.compose;

import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphNavigator;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes3.dex */
@Navigator.Name("navigation")
@Metadata
public final class ComposeNavGraphNavigator extends NavGraphNavigator {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ComposeNavGraph extends NavGraph {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Function1 f49045k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Function1 f49046l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Function1 f49047m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Function1 f49048n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private Function1 f49049o;

        public ComposeNavGraph(Navigator navigator) {
            super(navigator);
        }

        public final Function1 Z() {
            return this.f49045k;
        }

        public final Function1 a0() {
            return this.f49046l;
        }

        public final Function1 b0() {
            return this.f49047m;
        }

        public final Function1 c0() {
            return this.f49048n;
        }

        public final Function1 d0() {
            return this.f49049o;
        }
    }

    public ComposeNavGraphNavigator(NavigatorProvider navigatorProvider) {
        super(navigatorProvider);
    }

    @Override // androidx.navigation.NavGraphNavigator, androidx.navigation.Navigator
    /* JADX INFO: renamed from: q */
    public NavGraph c() {
        return new ComposeNavGraph(this);
    }
}
