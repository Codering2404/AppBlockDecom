package androidx.compose.material;

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
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
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
public final class OutlinedTextFieldKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f13329a = Dp.g(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f13330b = TextUnitKt.i(8);

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
    /* JADX WARN: Removed duplicated region for block: B:307:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:334:? A[RETURN, SYNTHETIC] */
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
            Method dump skipped, instruction units count: 1700
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.a(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.b(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:327:? A[RETURN, SYNTHETIC] */
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
            Method dump skipped, instruction units count: 1638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.c(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
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
    public static final /* synthetic */ void d(final java.lang.String r70, final kotlin.jvm.functions.Function1 r71, androidx.compose.ui.Modifier r72, boolean r73, boolean r74, androidx.compose.ui.text.TextStyle r75, kotlin.jvm.functions.Function2 r76, kotlin.jvm.functions.Function2 r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, boolean r80, androidx.compose.ui.text.input.VisualTransformation r81, androidx.compose.foundation.text.KeyboardOptions r82, androidx.compose.foundation.text.KeyboardActions r83, boolean r84, int r85, androidx.compose.foundation.interaction.MutableInteractionSource r86, androidx.compose.ui.graphics.Shape r87, androidx.compose.material.TextFieldColors r88, androidx.compose.runtime.Composer r89, final int r90, final int r91, final int r92) {
        /*
            Method dump skipped, instruction units count: 1223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.d(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void e(final Modifier modifier, final Function2 function2, final Function3 function3, final Function2 function22, final Function2 function23, final Function2 function24, final boolean z2, final float f3, final Function1 function1, final Function2 function25, final PaddingValues paddingValues, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        Composer composerK = composer.k(-2049536174);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(function3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function22) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.I(function23) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.I(function24) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i5 |= composerK.b(z2) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i5 |= composerK.c(f3) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i5 |= composerK.I(function1) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i5 |= composerK.I(function25) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.Z(paddingValues) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i5 & 306783379) == 306783378 && (i6 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-2049536174, i5, i6, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:507)");
            }
            boolean z3 = ((3670016 & i5) == 1048576) | ((234881024 & i5) == 67108864) | ((29360128 & i5) == 8388608) | ((i6 & 14) == 4);
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new OutlinedTextFieldMeasurePolicy(function1, z2, f3, paddingValues);
                composerK.w(objG);
            }
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) objG;
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
            Updater.e(composerA, outlinedTextFieldMeasurePolicy, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            function25.invoke(composerK, Integer.valueOf((i5 >> 27) & 14));
            if (function23 != null) {
                composerK.a0(-988654503);
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
                function23.invoke(composerK, Integer.valueOf((i5 >> 12) & 14));
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(-988413292);
                composerK.U();
            }
            if (function24 != null) {
                composerK.a0(-988370729);
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
                function24.invoke(composerK, Integer.valueOf((i5 >> 15) & 14));
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(-988127596);
                composerK.U();
            }
            float fG = PaddingKt.g(paddingValues, layoutDirection);
            float f4 = PaddingKt.f(paddingValues, layoutDirection);
            Modifier.Companion companion2 = Modifier.b8;
            if (function23 != null) {
                i7 = 0;
                fG = Dp.g(RangesKt.e(Dp.g(fG - TextFieldImplKt.d()), Dp.g(0)));
            } else {
                i7 = 0;
            }
            float f5 = fG;
            if (function24 != null) {
                f4 = Dp.g(RangesKt.e(Dp.g(f4 - TextFieldImplKt.d()), Dp.g(i7)));
            }
            Modifier modifierM = PaddingKt.m(companion2, f5, 0.0f, f4, 0.0f, 10, null);
            if (function3 != null) {
                composerK.a0(-987369863);
                function3.invoke(LayoutIdKt.b(companion2, "Hint").then(modifierM), composerK, Integer.valueOf((i5 >> 3) & 112));
                composerK.U();
            } else {
                composerK.a0(-987282412);
                composerK.U();
            }
            Modifier modifierThen3 = LayoutIdKt.b(companion2, "TextField").then(modifierM);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG3 = BoxKt.g(companion3.o(), true);
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
            function2.invoke(composerK, Integer.valueOf((i5 >> 3) & 14));
            composerK.y();
            if (function22 != null) {
                composerK.a0(-987052578);
                Modifier modifierB = LayoutIdKt.b(companion2, "Label");
                MeasurePolicy measurePolicyG4 = BoxKt.g(companion3.o(), false);
                int iA5 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU5 = composerK.u();
                Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierB);
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
                function22.invoke(composerK, Integer.valueOf((i5 >> 9) & 14));
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(-986969932);
                composerK.U();
            }
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextFieldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    OutlinedTextFieldKt.e(modifier, function2, function3, function22, function23, function24, z2, f3, function1, function25, paddingValues, composer2, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(int i3, int i4, int i5, int i6, int i7, float f3, long j3, float f4, PaddingValues paddingValues) {
        int iMax = Math.max(i5, Math.max(i7, MathHelpersKt.c(i6, 0, f3)));
        float fD = paddingValues.d() * f4;
        return Math.max(Constraints.m(j3), Math.max(i3, Math.max(i4, MathKt.d(MathHelpersKt.b(fD, Math.max(fD, i6 / 2.0f), f3) + iMax + (paddingValues.a() * f4)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(int i3, int i4, int i5, int i6, int i7, float f3, long j3, float f4, PaddingValues paddingValues) {
        int iMax = i3 + Math.max(i5, Math.max(MathHelpersKt.c(i6, 0, f3), i7)) + i4;
        LayoutDirection layoutDirection = LayoutDirection.f30001a;
        return Math.max(iMax, Math.max(MathKt.d((i6 + (Dp.g(paddingValues.b(layoutDirection) + paddingValues.c(layoutDirection)) * f4)) * f3), Constraints.n(j3)));
    }

    public static final Modifier m(Modifier modifier, final long j3, final PaddingValues paddingValues) {
        return DrawModifierKt.d(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f13472a;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.f30002b.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f13472a = iArr;
                }
            }

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
                float fI = Size.i(j3);
                if (fI <= 0.0f) {
                    contentDrawScope.i2();
                    return;
                }
                float fM1 = contentDrawScope.M1(OutlinedTextFieldKt.f13329a);
                float fM12 = contentDrawScope.M1(paddingValues.b(contentDrawScope.getLayoutDirection())) - fM1;
                float f3 = 2;
                float fI2 = fI + fM12 + (fM1 * f3);
                LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
                int[] iArr = WhenMappings.f13472a;
                float fI3 = iArr[layoutDirection.ordinal()] == 1 ? Size.i(contentDrawScope.b()) - fI2 : RangesKt.e(fM12, 0.0f);
                if (iArr[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                    fI2 = Size.i(contentDrawScope.b()) - RangesKt.e(fM12, 0.0f);
                }
                float f4 = fI2;
                float fG = Size.g(j3);
                float f5 = (-fG) / f3;
                float f6 = fG / f3;
                int iA = ClipOp.f25711b.a();
                DrawContext drawContextQ1 = contentDrawScope.Q1();
                long jB = drawContextQ1.b();
                drawContextQ1.g().t();
                try {
                    drawContextQ1.e().c(fI3, f5, f4, f6, iA);
                    contentDrawScope.i2();
                } finally {
                    drawContextQ1.g().k();
                    drawContextQ1.h(jB);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Placeable.PlacementScope placementScope, int i3, int i4, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, float f3, boolean z2, float f4, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int iD = MathKt.d(paddingValues.d() * f4);
        int iD2 = MathKt.d(PaddingKt.g(paddingValues, layoutDirection) * f4);
        float fD = TextFieldImplKt.d() * f4;
        if (placeable != null) {
            Placeable.PlacementScope.m(placementScope, placeable, 0, Alignment.f25072a.i().a(placeable.O0(), i3), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.m(placementScope, placeable2, i4 - placeable2.X0(), Alignment.f25072a.i().a(placeable2.O0(), i3), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.m(placementScope, placeable4, MathKt.d(placeable == null ? 0.0f : (TextFieldImplKt.j(placeable) - fD) * (1 - f3)) + iD2, MathHelpersKt.c(z2 ? Alignment.f25072a.i().a(placeable4.O0(), i3) : iD, -(placeable4.O0() / 2), f3), 0.0f, 4, null);
        }
        Placeable.PlacementScope.m(placementScope, placeable3, TextFieldImplKt.j(placeable), Math.max(z2 ? Alignment.f25072a.i().a(placeable3.O0(), i3) : iD, TextFieldImplKt.i(placeable4) / 2), 0.0f, 4, null);
        if (placeable5 != null) {
            if (z2) {
                iD = Alignment.f25072a.i().a(placeable5.O0(), i3);
            }
            Placeable.PlacementScope.m(placementScope, placeable5, TextFieldImplKt.j(placeable), Math.max(iD, TextFieldImplKt.i(placeable4) / 2), 0.0f, 4, null);
        }
        Placeable.PlacementScope.k(placementScope, placeable6, IntOffset.f29988b.b(), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(int i3, int i4) {
        return i3 == Integer.MAX_VALUE ? i3 : i3 - i4;
    }
}
