package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

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
public final class TextFieldKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f14818a = Dp.g(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f14819b = Dp.g(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f14820c = Dp.g(2);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:329:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.ui.text.input.TextFieldValue r73, final kotlin.jvm.functions.Function1 r74, androidx.compose.ui.Modifier r75, boolean r76, boolean r77, androidx.compose.ui.text.TextStyle r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, kotlin.jvm.functions.Function2 r81, kotlin.jvm.functions.Function2 r82, boolean r83, androidx.compose.ui.text.input.VisualTransformation r84, androidx.compose.foundation.text.KeyboardOptions r85, androidx.compose.foundation.text.KeyboardActions r86, boolean r87, int r88, int r89, androidx.compose.foundation.interaction.MutableInteractionSource r90, androidx.compose.ui.graphics.Shape r91, androidx.compose.material.TextFieldColors r92, androidx.compose.runtime.Composer r93, final int r94, final int r95, final int r96) {
        /*
            Method dump skipped, instruction units count: 1662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.a(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:304:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void b(final androidx.compose.ui.text.input.TextFieldValue r71, final kotlin.jvm.functions.Function1 r72, androidx.compose.ui.Modifier r73, boolean r74, boolean r75, androidx.compose.ui.text.TextStyle r76, kotlin.jvm.functions.Function2 r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, androidx.compose.foundation.interaction.MutableInteractionSource r87, androidx.compose.ui.graphics.Shape r88, androidx.compose.material.TextFieldColors r89, androidx.compose.runtime.Composer r90, final int r91, final int r92, final int r93) {
        /*
            Method dump skipped, instruction units count: 1260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.b(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:329:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final java.lang.String r73, final kotlin.jvm.functions.Function1 r74, androidx.compose.ui.Modifier r75, boolean r76, boolean r77, androidx.compose.ui.text.TextStyle r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, kotlin.jvm.functions.Function2 r81, kotlin.jvm.functions.Function2 r82, boolean r83, androidx.compose.ui.text.input.VisualTransformation r84, androidx.compose.foundation.text.KeyboardOptions r85, androidx.compose.foundation.text.KeyboardActions r86, boolean r87, int r88, int r89, androidx.compose.foundation.interaction.MutableInteractionSource r90, androidx.compose.ui.graphics.Shape r91, androidx.compose.material.TextFieldColors r92, androidx.compose.runtime.Composer r93, final int r94, final int r95, final int r96) {
        /*
            Method dump skipped, instruction units count: 1662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.c(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:304:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void d(final java.lang.String r71, final kotlin.jvm.functions.Function1 r72, androidx.compose.ui.Modifier r73, boolean r74, boolean r75, androidx.compose.ui.text.TextStyle r76, kotlin.jvm.functions.Function2 r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, androidx.compose.foundation.interaction.MutableInteractionSource r87, androidx.compose.ui.graphics.Shape r88, androidx.compose.material.TextFieldColors r89, androidx.compose.runtime.Composer r90, final int r91, final int r92, final int r93) {
        /*
            Method dump skipped, instruction units count: 1294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.d(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void e(final Modifier modifier, final Function2 function2, final Function2 function22, final Function3 function3, final Function2 function23, final Function2 function24, final boolean z2, final float f3, final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        int i5;
        Composer composerK = composer.k(-2112507061);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function22) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function23) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function24) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.b(z2) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.c(f3) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.Z(paddingValues) ? 67108864 : 33554432;
        }
        if ((38347923 & i4) == 38347922 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-2112507061, i4, -1, "androidx.compose.material.TextFieldLayout (TextField.kt:488)");
            }
            boolean z3 = ((3670016 & i4) == 1048576) | ((29360128 & i4) == 8388608) | ((234881024 & i4) == 67108864);
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new TextFieldMeasurePolicy(z2, f3, paddingValues);
                composerK.w(objG);
            }
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) objG;
            LayoutDirection layoutDirection = (LayoutDirection) composerK.q(CompositionLocalsKt.m());
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, textFieldMeasurePolicy, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            if (function23 != null) {
                composerK.a0(69542167);
                Modifier modifierThen = LayoutIdKt.b(Modifier.b8, "Leading").then(TextFieldImplKt.e());
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierThen);
                Function0 function0A2 = companion.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A2);
                } else {
                    composerK.v();
                }
                Composer composerA2 = Updater.a(composerK);
                Updater.e(composerA2, measurePolicyG, companion.e());
                Updater.e(composerA2, compositionLocalMapU2, companion.g());
                Function2 function2B2 = companion.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                function23.invoke(composerK, Integer.valueOf((i4 >> 12) & 14));
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(69783378);
                composerK.U();
            }
            if (function24 != null) {
                composerK.a0(69825941);
                Modifier modifierThen2 = LayoutIdKt.b(Modifier.b8, "Trailing").then(TextFieldImplKt.e());
                MeasurePolicy measurePolicyG2 = BoxKt.g(Alignment.f25072a.e(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierThen2);
                Function0 function0A3 = companion.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A3);
                } else {
                    composerK.v();
                }
                Composer composerA3 = Updater.a(composerK);
                Updater.e(composerA3, measurePolicyG2, companion.e());
                Updater.e(composerA3, compositionLocalMapU3, companion.g());
                Function2 function2B3 = companion.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion.f());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                function24.invoke(composerK, Integer.valueOf((i4 >> 15) & 14));
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(70069074);
                composerK.U();
            }
            float fG = PaddingKt.g(paddingValues, layoutDirection);
            float f4 = PaddingKt.f(paddingValues, layoutDirection);
            Modifier.Companion companion2 = Modifier.b8;
            if (function23 != null) {
                i5 = 0;
                fG = Dp.g(RangesKt.e(Dp.g(fG - TextFieldImplKt.d()), Dp.g(0)));
            } else {
                i5 = 0;
            }
            float f5 = fG;
            if (function24 != null) {
                f4 = Dp.g(RangesKt.e(Dp.g(f4 - TextFieldImplKt.d()), Dp.g(i5)));
            }
            Modifier modifierM = PaddingKt.m(companion2, f5, 0.0f, f4, 0.0f, 10, null);
            if (function3 != null) {
                composerK.a0(70826807);
                function3.invoke(LayoutIdKt.b(companion2, "Hint").then(modifierM), composerK, Integer.valueOf((i4 >> 6) & 112));
                composerK.U();
            } else {
                composerK.a0(70914258);
                composerK.U();
            }
            if (function22 != null) {
                composerK.a0(70948761);
                Modifier modifierThen3 = LayoutIdKt.b(companion2, "Label").then(modifierM);
                MeasurePolicy measurePolicyG3 = BoxKt.g(Alignment.f25072a.o(), false);
                int iA4 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU4 = composerK.u();
                Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierThen3);
                Function0 function0A4 = companion.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A4);
                } else {
                    composerK.v();
                }
                Composer composerA4 = Updater.a(composerK);
                Updater.e(composerA4, measurePolicyG3, companion.e());
                Updater.e(composerA4, compositionLocalMapU4, companion.g());
                Function2 function2B4 = companion.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF4, companion.f());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.f6642a;
                function22.invoke(composerK, Integer.valueOf((i4 >> 6) & 14));
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(71034290);
                composerK.U();
            }
            Modifier modifierThen4 = LayoutIdKt.b(companion2, "TextField").then(modifierM);
            MeasurePolicy measurePolicyG4 = BoxKt.g(Alignment.f25072a.o(), true);
            int iA5 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU5 = composerK.u();
            Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierThen4);
            Function0 function0A5 = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A5);
            } else {
                composerK.v();
            }
            Composer composerA5 = Updater.a(composerK);
            Updater.e(composerA5, measurePolicyG4, companion.e());
            Updater.e(composerA5, compositionLocalMapU5, companion.g());
            Function2 function2B5 = companion.b();
            if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                composerA5.w(Integer.valueOf(iA5));
                composerA5.p(Integer.valueOf(iA5), function2B5);
            }
            Updater.e(composerA5, modifierF5, companion.f());
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.f6642a;
            function2.invoke(composerK, Integer.valueOf((i4 >> 3) & 14));
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextFieldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    TextFieldKt.e(modifier, function2, function22, function3, function23, function24, z2, f3, paddingValues, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(int i3, boolean z2, int i4, int i5, int i6, int i7, long j3, float f3, PaddingValues paddingValues) {
        float f4 = f14820c * f3;
        float fD = paddingValues.d() * f3;
        float fA = paddingValues.a() * f3;
        int iMax = Math.max(i3, i7);
        return Math.max(MathKt.d(z2 ? i4 + f4 + iMax + fA : fD + iMax + fA), Math.max(Math.max(i5, i6), Constraints.m(j3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(int i3, int i4, int i5, int i6, int i7, long j3) {
        return Math.max(i3 + Math.max(i5, Math.max(i6, i7)) + i4, Constraints.n(j3));
    }

    public static final Modifier m(Modifier modifier, final BorderStroke borderStroke) {
        final float fB = borderStroke.b();
        return DrawModifierKt.d(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.TextFieldKt$drawIndicatorLine$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                contentDrawScope.i2();
                if (Dp.i(fB, Dp.f29970b.a())) {
                    return;
                }
                float density = fB * contentDrawScope.getDensity();
                float fG = Size.g(contentDrawScope.b()) - (density / 2);
                DrawScope.h2(contentDrawScope, borderStroke.a(), OffsetKt.a(0.0f, fG), OffsetKt.a(Size.i(contentDrawScope.b()), fG), density, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float n() {
        return f14818a;
    }

    public static final float o() {
        return f14819b;
    }

    public static final float p() {
        return f14820c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Placeable.PlacementScope placementScope, int i3, int i4, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z2, int i5, int i6, float f3, float f4) {
        if (placeable4 != null) {
            Placeable.PlacementScope.m(placementScope, placeable4, 0, Alignment.f25072a.i().a(placeable4.O0(), i4), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.m(placementScope, placeable5, i3 - placeable5.X0(), Alignment.f25072a.i().a(placeable5.O0(), i4), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.m(placementScope, placeable2, TextFieldImplKt.j(placeable4), (z2 ? Alignment.f25072a.i().a(placeable2.O0(), i4) : MathKt.d(TextFieldImplKt.g() * f4)) - MathKt.d((r0 - i5) * f3), 0.0f, 4, null);
        }
        Placeable.PlacementScope.m(placementScope, placeable, TextFieldImplKt.j(placeable4), i6, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.m(placementScope, placeable3, TextFieldImplKt.j(placeable4), i6, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Placeable.PlacementScope placementScope, int i3, int i4, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, boolean z2, float f3, PaddingValues paddingValues) {
        int iD = MathKt.d(paddingValues.d() * f3);
        if (placeable3 != null) {
            Placeable.PlacementScope.m(placementScope, placeable3, 0, Alignment.f25072a.i().a(placeable3.O0(), i4), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.m(placementScope, placeable4, i3 - placeable4.X0(), Alignment.f25072a.i().a(placeable4.O0(), i4), 0.0f, 4, null);
        }
        Placeable.PlacementScope.m(placementScope, placeable, TextFieldImplKt.j(placeable3), z2 ? Alignment.f25072a.i().a(placeable.O0(), i4) : iD, 0.0f, 4, null);
        if (placeable2 != null) {
            if (z2) {
                iD = Alignment.f25072a.i().a(placeable2.O0(), i4);
            }
            Placeable.PlacementScope.m(placementScope, placeable2, TextFieldImplKt.j(placeable3), iD, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s(int i3, int i4) {
        return i3 == Integer.MAX_VALUE ? i3 : i3 - i4;
    }
}
