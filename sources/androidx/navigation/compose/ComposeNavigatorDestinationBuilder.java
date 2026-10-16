package androidx.navigation.compose;

import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.compose.ComposeNavigator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
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
public final class ComposeNavigatorDestinationBuilder extends NavDestinationBuilder<ComposeNavigator.Destination> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ComposeNavigator f49060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Function4 f49061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Function1 f49062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Function1 f49063l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Function1 f49064m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Function1 f49065n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Function1 f49066o;

    public ComposeNavigatorDestinationBuilder(ComposeNavigator composeNavigator, String str, Function4 function4) {
        super(composeNavigator, str);
        this.f49060i = composeNavigator;
        this.f49061j = function4;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ComposeNavigator.Destination b() {
        ComposeNavigator.Destination destination = (ComposeNavigator.Destination) super.b();
        destination.N(this.f49062k);
        destination.O(this.f49063l);
        destination.P(this.f49064m);
        destination.Q(this.f49065n);
        destination.R(this.f49066o);
        return destination;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.navigation.NavDestinationBuilder
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ComposeNavigator.Destination e() {
        return new ComposeNavigator.Destination(this.f49060i, this.f49061j);
    }

    public final void h(Function1 function1) {
        this.f49062k = function1;
    }

    public final void i(Function1 function1) {
        this.f49063l = function1;
    }

    public final void j(Function1 function1) {
        this.f49064m = function1;
    }

    public final void k(Function1 function1) {
        this.f49065n = function1;
    }

    public final void l(Function1 function1) {
        this.f49066o = function1;
    }

    public ComposeNavigatorDestinationBuilder(ComposeNavigator composeNavigator, KClass kClass, Map map, Function4 function4) {
        super(composeNavigator, kClass, map);
        this.f49060i = composeNavigator;
        this.f49061j = function4;
    }
}
