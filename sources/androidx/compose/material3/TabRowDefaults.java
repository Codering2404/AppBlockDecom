package androidx.compose.material3;

import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.material3.tokens.SecondaryNavigationTabTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class TabRowDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TabRowDefaults f20571a = new TabRowDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f20572b = Dp.g(52);

    private TabRowDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(androidx.compose.ui.Modifier r14, float r15, long r16, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowDefaults.a(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(androidx.compose.ui.Modifier r17, float r18, float r19, long r20, androidx.compose.ui.graphics.Shape r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowDefaults.b(androidx.compose.ui.Modifier, float, float, long, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(androidx.compose.ui.Modifier r14, float r15, long r16, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowDefaults.c(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }

    public final long d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-2069154037, i3, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContainerColor> (TabRow.kt:1163)");
        }
        long jI = ColorSchemeKt.i(PrimaryNavigationTabTokens.f23247a.e(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final long e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1410362619, i3, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContentColor> (TabRow.kt:1179)");
        }
        long jI = ColorSchemeKt.i(PrimaryNavigationTabTokens.f23247a.d(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final float f() {
        return f20572b;
    }

    public final long g(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1938007129, i3, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContainerColor> (TabRow.kt:1167)");
        }
        long jI = ColorSchemeKt.i(SecondaryNavigationTabTokens.f23343a.b(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final long h(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1166419479, i3, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContentColor> (TabRow.kt:1183)");
        }
        long jI = ColorSchemeKt.i(SecondaryNavigationTabTokens.f23343a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final Modifier i(Modifier modifier, final TabPosition tabPosition) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("tabIndicatorOffset");
                inspectorInfo.e(tabPosition);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new TabRowDefaults$tabIndicatorOffset$2(tabPosition));
    }
}
