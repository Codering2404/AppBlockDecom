package androidx.glance.appwidget.translators;

import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.ColorFilterParams;
import androidx.glance.EmittableImage;
import androidx.glance.IconImageProvider;
import androidx.glance.ImageKt;
import androidx.glance.TintColorFilterParams;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.TintAndAlphaColorFilterParams;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.layout.ContentScale;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;

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
public final class ImageTranslatorKt {
    private static final void a(TranslationContext translationContext, RemoteViews remoteViews, ColorFilterParams colorFilterParams, InsertedViewInfo insertedViewInfo) {
        if (colorFilterParams instanceof TintColorFilterParams) {
            ColorProvider colorProviderA = ((TintColorFilterParams) colorFilterParams).a();
            if (Build.VERSION.SDK_INT >= 31) {
                ImageTranslatorApi31Impl.f39376a.a(translationContext, remoteViews, colorProviderA, insertedViewInfo.e());
                return;
            } else {
                RemoteViewsCompat.f(remoteViews, insertedViewInfo.e(), ColorKt.k(colorProviderA.a(translationContext.n())));
                return;
            }
        }
        if (!(colorFilterParams instanceof TintAndAlphaColorFilterParams)) {
            throw new IllegalArgumentException("An unsupported ColorFilter was used.");
        }
        if (Build.VERSION.SDK_INT > 30) {
            throw new IllegalStateException("There is no use case yet to support this colorFilter in S+ versions.");
        }
        int iK = ColorKt.k(((TintAndAlphaColorFilterParams) colorFilterParams).a().a(translationContext.n()));
        RemoteViewsCompat.f(remoteViews, insertedViewInfo.e(), iK);
        RemoteViewsCompat.i(remoteViews, insertedViewInfo.e(), Color.alpha(iK));
    }

    private static final LayoutType b(EmittableImage emittableImage) {
        boolean zC = ImageKt.c(emittableImage);
        int iD = emittableImage.d();
        ContentScale.Companion companion = ContentScale.f39463b;
        if (ContentScale.g(iD, companion.a())) {
            return zC ? LayoutType.ImageCropDecorative : LayoutType.ImageCrop;
        }
        if (ContentScale.g(iD, companion.c())) {
            return zC ? LayoutType.ImageFitDecorative : LayoutType.ImageFit;
        }
        if (ContentScale.g(iD, companion.b())) {
            return zC ? LayoutType.ImageFillBoundsDecorative : LayoutType.ImageFillBounds;
        }
        Log.w("GlanceAppWidget", "Unsupported ContentScale user: " + ((Object) ContentScale.i(emittableImage.d())));
        return LayoutType.ImageFit;
    }

    public static final void c(RemoteViews remoteViews, int i3, long j3, long j4) {
        RemoteViewsCompat.g(remoteViews, i3, ColorKt.k(j3), ColorKt.k(j4));
    }

    private static final void d(RemoteViews remoteViews, int i3, IconImageProvider iconImageProvider) {
        ImageTranslatorApi23Impl.f39375a.a(remoteViews, i3, iconImageProvider.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(android.widget.RemoteViews r3, androidx.glance.appwidget.TranslationContext r4, androidx.glance.EmittableImage r5) {
        /*
            androidx.glance.appwidget.LayoutType r0 = b(r5)
            androidx.glance.GlanceModifier r1 = r5.a()
            androidx.glance.appwidget.InsertedViewInfo r0 = androidx.glance.appwidget.LayoutSelectionKt.d(r3, r4, r0, r1)
            androidx.glance.ImageProvider r1 = r5.e()
            boolean r2 = r1 instanceof androidx.glance.AndroidResourceImageProvider
            if (r2 == 0) goto L22
            int r2 = r0.e()
            androidx.glance.AndroidResourceImageProvider r1 = (androidx.glance.AndroidResourceImageProvider) r1
            int r1 = r1.a()
            r3.setImageViewResource(r2, r1)
            goto L53
        L22:
            boolean r2 = r1 instanceof androidx.glance.BitmapImageProvider
            if (r2 == 0) goto L34
            int r2 = r0.e()
            androidx.glance.BitmapImageProvider r1 = (androidx.glance.BitmapImageProvider) r1
            android.graphics.Bitmap r1 = r1.a()
            r3.setImageViewBitmap(r2, r1)
            goto L53
        L34:
            boolean r2 = r1 instanceof androidx.glance.appwidget.UriImageProvider
            if (r2 == 0) goto L46
            int r2 = r0.e()
            androidx.glance.appwidget.UriImageProvider r1 = (androidx.glance.appwidget.UriImageProvider) r1
            android.net.Uri r1 = r1.a()
            r3.setImageViewUri(r2, r1)
            goto L53
        L46:
            boolean r2 = r1 instanceof androidx.glance.IconImageProvider
            if (r2 == 0) goto Lb3
            int r2 = r0.e()
            androidx.glance.IconImageProvider r1 = (androidx.glance.IconImageProvider) r1
            d(r3, r2, r1)
        L53:
            androidx.glance.ColorFilterParams r1 = r5.c()
            if (r1 == 0) goto L5c
            a(r4, r3, r1, r0)
        L5c:
            androidx.glance.GlanceModifier r1 = r5.a()
            androidx.glance.appwidget.ApplyModifiersKt.c(r4, r3, r1, r0)
            int r4 = r5.d()
            androidx.glance.layout.ContentScale$Companion r1 = androidx.glance.layout.ContentScale.f39463b
            int r1 = r1.c()
            boolean r4 = androidx.glance.layout.ContentScale.g(r4, r1)
            if (r4 == 0) goto Laa
            androidx.glance.GlanceModifier r4 = r5.a()
            androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1 r1 = new kotlin.jvm.functions.Function2<androidx.glance.layout.WidthModifier, androidx.glance.GlanceModifier.Element, androidx.glance.layout.WidthModifier>() { // from class: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1
                static {
                    /*
                        androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1 r0 = new androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1) androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1.a androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 2
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final java.lang.Object invoke(java.lang.Object r2, androidx.glance.GlanceModifier.Element r3) {
                    /*
                        r1 = this;
                        boolean r0 = r3 instanceof androidx.glance.layout.WidthModifier
                        if (r0 == 0) goto L5
                        return r3
                    L5:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1.invoke(java.lang.Object, androidx.glance.GlanceModifier$Element):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                    /*
                        r0 = this;
                        androidx.glance.GlanceModifier$Element r2 = (androidx.glance.GlanceModifier.Element) r2
                        java.lang.Object r1 = r0.invoke(r1, r2)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
                }
            }
            r2 = 0
            java.lang.Object r4 = r4.foldIn(r2, r1)
            androidx.glance.layout.WidthModifier r4 = (androidx.glance.layout.WidthModifier) r4
            if (r4 == 0) goto L87
            androidx.glance.unit.Dimension r4 = r4.b()
            goto L88
        L87:
            r4 = r2
        L88:
            androidx.glance.unit.Dimension$Wrap r1 = androidx.glance.unit.Dimension.Wrap.f39790a
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r4 != 0) goto La8
            androidx.glance.GlanceModifier r4 = r5.a()
            androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2 r5 = new kotlin.jvm.functions.Function2<androidx.glance.layout.HeightModifier, androidx.glance.GlanceModifier.Element, androidx.glance.layout.HeightModifier>() { // from class: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2
                static {
                    /*
                        androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2 r0 = new androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2) androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2.a androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 2
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final java.lang.Object invoke(java.lang.Object r2, androidx.glance.GlanceModifier.Element r3) {
                    /*
                        r1 = this;
                        boolean r0 = r3 instanceof androidx.glance.layout.HeightModifier
                        if (r0 == 0) goto L5
                        return r3
                    L5:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2.invoke(java.lang.Object, androidx.glance.GlanceModifier$Element):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                    /*
                        r0 = this;
                        androidx.glance.GlanceModifier$Element r2 = (androidx.glance.GlanceModifier.Element) r2
                        java.lang.Object r1 = r0.invoke(r1, r2)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
                }
            }
            java.lang.Object r4 = r4.foldIn(r2, r5)
            androidx.glance.layout.HeightModifier r4 = (androidx.glance.layout.HeightModifier) r4
            if (r4 == 0) goto La2
            androidx.glance.unit.Dimension r2 = r4.b()
        La2:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r1)
            if (r4 == 0) goto Laa
        La8:
            r4 = 1
            goto Lab
        Laa:
            r4 = 0
        Lab:
            int r5 = r0.e()
            androidx.core.widget.RemoteViewsCompat.e(r3, r5, r4)
            return
        Lb3:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "An unsupported ImageProvider type was used."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.translators.ImageTranslatorKt.e(android.widget.RemoteViews, androidx.glance.appwidget.TranslationContext, androidx.glance.EmittableImage):void");
    }
}
