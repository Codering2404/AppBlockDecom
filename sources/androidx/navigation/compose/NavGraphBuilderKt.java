package androidx.navigation.compose;

import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavGraphBuilder;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
@Metadata
public final class NavGraphBuilderKt {
    public static final void a(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function4 function4) {
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder = new ComposeNavigatorDestinationBuilder((ComposeNavigator) navGraphBuilder.j().d(ComposeNavigator.class), str, function4);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NamedNavArgument namedNavArgument = (NamedNavArgument) it.next();
            composeNavigatorDestinationBuilder.a(namedNavArgument.a(), namedNavArgument.b());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            composeNavigatorDestinationBuilder.c((NavDeepLink) it2.next());
        }
        composeNavigatorDestinationBuilder.h(function1);
        composeNavigatorDestinationBuilder.i(function12);
        composeNavigatorDestinationBuilder.j(function13);
        composeNavigatorDestinationBuilder.k(function14);
        composeNavigatorDestinationBuilder.l(function15);
        navGraphBuilder.i(composeNavigatorDestinationBuilder);
    }

    public static final void b(NavGraphBuilder navGraphBuilder, KClass kClass, Map map, List list, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function4 function4) {
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder = new ComposeNavigatorDestinationBuilder((ComposeNavigator) navGraphBuilder.j().d(ComposeNavigator.class), kClass, map, function4);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            composeNavigatorDestinationBuilder.c((NavDeepLink) it.next());
        }
        composeNavigatorDestinationBuilder.h(function1);
        composeNavigatorDestinationBuilder.i(function12);
        composeNavigatorDestinationBuilder.j(function13);
        composeNavigatorDestinationBuilder.k(function14);
        composeNavigatorDestinationBuilder.l(function15);
        navGraphBuilder.i(composeNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void c(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function4 function4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        List list3 = list;
        if ((i3 & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        List list4 = list2;
        Function1 function16 = (i3 & 8) != 0 ? null : function1;
        Function1 function17 = (i3 & 16) != 0 ? null : function12;
        a(navGraphBuilder, str, list3, list4, function16, function17, (i3 & 32) != 0 ? function16 : function13, (i3 & 64) != 0 ? function17 : function14, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : function15, function4);
    }
}
