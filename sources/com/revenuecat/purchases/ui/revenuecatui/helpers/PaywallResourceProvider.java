package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import androidx.compose.ui.text.font.FontFamily;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.ui.revenuecatui.utils.FontFamilyXmlParser;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallResourceProvider implements ResourceProvider {
    public static final int $stable = 8;
    private final String applicationName;
    private final String packageName;
    private final Resources resources;

    public PaywallResourceProvider(String applicationName, String packageName, Resources resources) {
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.applicationName = applicationName;
        this.packageName = packageName;
        this.resources = resources;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public String getApplicationName() {
        return this.applicationName;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.String> getAssetFontPaths(java.util.List<java.lang.String> r10) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "names"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.content.res.Resources r0 = r9.resources
            android.content.res.AssetManager r0 = r0.getAssets()
            java.lang.String r1 = "fonts"
            java.lang.String[] r0 = r0.list(r1)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r10 = r10.iterator()
        L1c:
            boolean r2 = r10.hasNext()
            r3 = 0
            if (r2 == 0) goto L77
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            r4 = 2
            java.lang.String r5 = ".ttf"
            r6 = 0
            boolean r4 = kotlin.text.StringsKt.E(r2, r5, r6, r4, r3)
            if (r4 == 0) goto L35
            r4 = r2
            goto L44
        L35:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L44:
            if (r0 == 0) goto L6a
            int r5 = r0.length
        L47:
            if (r6 >= r5) goto L55
            r7 = r0[r6]
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)
            if (r8 == 0) goto L52
            goto L56
        L52:
            int r6 = r6 + 1
            goto L47
        L55:
            r7 = r3
        L56:
            if (r7 == 0) goto L6a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "fonts/"
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            goto L6b
        L6a:
            r4 = r3
        L6b:
            if (r4 == 0) goto L71
            kotlin.Pair r3 = kotlin.TuplesKt.a(r2, r4)
        L71:
            if (r3 == 0) goto L1c
            r1.add(r3)
            goto L1c
        L77:
            java.util.Map r10 = kotlin.collections.MapsKt.toMap(r1)
            boolean r0 = r10.isEmpty()
            if (r0 != 0) goto L82
            return r10
        L82:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallResourceProvider.getAssetFontPaths(java.util.List):java.util.Map");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public AssetManager getAssetManager() {
        return this.resources.getAssets();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        Purchases.Companion companion = Purchases.Companion;
        if (companion.isConfigured()) {
            return companion.getSharedInstance().getCachedFontFamilyOrStartDownload(fontInfo);
        }
        Logger.INSTANCE.e("getCachedFontFileOrStartDownload called before Purchases is configured. Returning null.");
        return null;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public Locale getLocale() {
        Locale locale = this.resources.getConfiguration().getLocales().get(0);
        Intrinsics.checkNotNullExpressionValue(locale, "resources.configuration.locales.get(0)");
        return locale;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public int getResourceIdentifier(String name, String type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return this.resources.getIdentifier(name, type, this.packageName);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public String getString(int i3, Object... formatArgs) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        String string = this.resources.getString(i3, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(resId, *formatArgs)");
        return string;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public FontFamily getXmlFontFamily(int i3) {
        try {
            XmlResourceParser xml = this.resources.getXml(i3);
            Intrinsics.checkNotNullExpressionValue(xml, "try {\n            resour…    return null\n        }");
            try {
                FontFamily fontFamily = FontFamilyXmlParser.INSTANCE.parse(xml);
                xml.close();
                return fontFamily;
            } catch (Throwable th) {
                try {
                    Object resourceEntryNameOrNull = PaywallResourceProviderKt.getResourceEntryNameOrNull(this.resources, i3);
                    Logger logger = Logger.INSTANCE;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error parsing XML font family with resource ID ");
                    if (resourceEntryNameOrNull == null) {
                        resourceEntryNameOrNull = Integer.valueOf(i3);
                    }
                    sb.append(resourceEntryNameOrNull);
                    logger.e(sb.toString(), th);
                    xml.close();
                    return null;
                } catch (Throwable th2) {
                    xml.close();
                    throw th2;
                }
            }
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PaywallResourceProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        String strApplicationName = PaywallResourceProviderKt.applicationName(applicationContext);
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this(strApplicationName, packageName, resources);
    }
}
