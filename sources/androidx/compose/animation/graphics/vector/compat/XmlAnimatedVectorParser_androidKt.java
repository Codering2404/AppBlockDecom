package androidx.compose.animation.graphics.vector.compat;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.animation.graphics.res.AnimatorResources_androidKt;
import androidx.compose.animation.graphics.vector.AnimatedImageVector;
import androidx.compose.animation.graphics.vector.AnimatedVectorTarget;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.VectorResources_androidKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

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
public final class XmlAnimatedVectorParser_androidKt {
    public static final AnimatedImageVector a(XmlPullParser xmlPullParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes;
        int[] iArrB = AndroidVectorResources.f4469a.b();
        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrB, 0, 0)) == null) {
            typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, iArrB);
        }
        try {
            int resourceId = typedArrayObtainAttributes.getResourceId(0, 0);
            ArrayList arrayList = new ArrayList();
            xmlPullParser.next();
            while (!XmlPullParserUtils_androidKt.a(xmlPullParser) && (xmlPullParser.getEventType() != 3 || !Intrinsics.areEqual(xmlPullParser.getName(), "animated-vector"))) {
                if (xmlPullParser.getEventType() == 2 && Intrinsics.areEqual(xmlPullParser.getName(), "target")) {
                    arrayList.add(b(resources, theme, attributeSet));
                }
                xmlPullParser.next();
            }
            AnimatedImageVector animatedImageVector = new AnimatedImageVector(VectorResources_androidKt.c(ImageVector.f26323k, theme, resources, resourceId), arrayList);
            typedArrayObtainAttributes.recycle();
            return animatedImageVector;
        } catch (Throwable th) {
            typedArrayObtainAttributes.recycle();
            throw th;
        }
    }

    private static final AnimatedVectorTarget b(Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes;
        int[] iArrC = AndroidVectorResources.f4469a.c();
        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrC, 0, 0)) == null) {
            typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, iArrC);
        }
        try {
            String string = typedArrayObtainAttributes.getString(0);
            if (string == null) {
                string = "";
            }
            AnimatedVectorTarget animatedVectorTarget = new AnimatedVectorTarget(string, AnimatorResources_androidKt.B(theme, resources, typedArrayObtainAttributes.getResourceId(1, 0)));
            typedArrayObtainAttributes.recycle();
            return animatedVectorTarget;
        } catch (Throwable th) {
            typedArrayObtainAttributes.recycle();
            throw th;
        }
    }
}
