package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageVectorCache;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParserException;

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
public final class PainterResources_androidKt {
    private static final ImageBitmap a(CharSequence charSequence, Resources resources, int i3) {
        try {
            return ImageResources_androidKt.a(ImageBitmap.f25782a, resources, i3);
        } catch (Exception e3) {
            throw new ResourceResolutionException("Error attempting to load resource: " + ((Object) charSequence), e3);
        }
    }

    private static final ImageVector b(Resources.Theme theme, Resources resources, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        if (ComposerKt.M()) {
            ComposerKt.U(21855625, i5, -1, "androidx.compose.ui.res.loadVectorResource (PainterResources.android.kt:89)");
        }
        ImageVectorCache imageVectorCache = (ImageVectorCache) composer.q(AndroidCompositionLocals_androidKt.h());
        ImageVectorCache.Key key = new ImageVectorCache.Key(theme, i3);
        ImageVectorCache.ImageVectorEntry imageVectorEntryB = imageVectorCache.b(key);
        if (imageVectorEntryB == null) {
            XmlResourceParser xml = resources.getXml(i3);
            if (!Intrinsics.areEqual(XmlVectorParser_androidKt.j(xml).getName(), "vector")) {
                throw new IllegalArgumentException("Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP");
            }
            imageVectorEntryB = VectorResources_androidKt.a(theme, resources, xml, i4);
            imageVectorCache.d(key, imageVectorEntryB);
        }
        ImageVector imageVectorB = imageVectorEntryB.b();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return imageVectorB;
    }

    public static final Painter c(int i3, Composer composer, int i4) {
        Painter painterH;
        if (ComposerKt.M()) {
            ComposerKt.U(473971343, i4, -1, "androidx.compose.ui.res.painterResource (PainterResources.android.kt:56)");
        }
        Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        composer.q(AndroidCompositionLocals_androidKt.f());
        Resources resources = context.getResources();
        TypedValue typedValueB = ((ResourceIdCache) composer.q(AndroidCompositionLocals_androidKt.i())).b(resources, i3);
        CharSequence charSequence = typedValueB.string;
        boolean z2 = true;
        if (charSequence == null || !StringsKt.f0(charSequence, ".xml", false, 2, null)) {
            composer.a0(-802887899);
            Object theme = context.getTheme();
            boolean Z = composer.Z(charSequence);
            if ((((i4 & 14) ^ 6) <= 4 || !composer.e(i3)) && (i4 & 6) != 4) {
                z2 = false;
            }
            boolean Z2 = composer.Z(theme) | Z | z2;
            Object objG = composer.G();
            if (Z2 || objG == Composer.f23746a.a()) {
                objG = a(charSequence, resources, i3);
                composer.w(objG);
            }
            BitmapPainter bitmapPainter = new BitmapPainter((ImageBitmap) objG, 0L, 0L, 6, null);
            composer.U();
            painterH = bitmapPainter;
        } else {
            composer.a0(-803043333);
            painterH = VectorPainterKt.h(b(context.getTheme(), resources, i3, typedValueB.changingConfigurations, composer, (i4 << 6) & 896), composer, 0);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return painterH;
    }
}
