package com.revenuecat.purchases.utils;

import android.net.Uri;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PartialCarouselComponent;
import com.revenuecat.purchases.paywalls.components.PartialImageComponent;
import com.revenuecat.purchases.paywalls.components.PartialStackComponent;
import com.revenuecat.purchases.paywalls.components.PartialTabsComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.VideoComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OfferingImagePreDownloader {
    private final CoilImageDownloader coilImageDownloader;
    private final boolean shouldPredownloadImages;

    public OfferingImagePreDownloader(boolean z2, CoilImageDownloader coilImageDownloader) {
        Intrinsics.checkNotNullParameter(coilImageDownloader, "coilImageDownloader");
        this.shouldPredownloadImages = z2;
        this.coilImageDownloader = coilImageDownloader;
    }

    private final void downloadV1Images(Offering offering) {
        PaywallData paywall = offering.getPaywall();
        if (paywall != null) {
            List<String> all$purchases_defaultsBc8Release = paywall.getConfig().getImages().getAll$purchases_defaultsBc8Release();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(all$purchases_defaultsBc8Release, 10));
            Iterator<T> it = all$purchases_defaultsBc8Release.iterator();
            while (it.hasNext()) {
                arrayList.add(Uri.parse(paywall.getAssetBaseURL().toString()).buildUpon().path((String) it.next()).build());
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                Uri it2 = (Uri) obj;
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Pre-downloading Paywall V1 image: " + it2);
                }
                CoilImageDownloader coilImageDownloader = this.coilImageDownloader;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                coilImageDownloader.downloadImage(it2);
            }
        }
    }

    private final void downloadV2Images(Offering offering) {
        Offering.PaywallComponents paywallComponents = offering.getPaywallComponents();
        if (paywallComponents != null) {
            for (Uri uri : findImageUrisToDownload(paywallComponents)) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Pre-downloading Paywall V2 image: " + uri);
                }
                this.coilImageDownloader.downloadImage(uri);
            }
        }
    }

    private final Set<Uri> findImageUrisToDownload(Offering.PaywallComponents paywallComponents) {
        StackComponent stack;
        PaywallComponentsConfig base = paywallComponents.getData().getComponentsConfig().getBase();
        Set<Uri> setFindImageUrisToDownload = findImageUrisToDownload(base.getStack());
        StickyFooterComponent stickyFooter = base.getStickyFooter();
        Set<Uri> setFindImageUrisToDownload2 = (stickyFooter == null || (stack = stickyFooter.getStack()) == null) ? null : findImageUrisToDownload(stack);
        if (setFindImageUrisToDownload2 == null) {
            setFindImageUrisToDownload2 = SetsKt.emptySet();
        }
        return SetsKt.plus(SetsKt.plus((Set) setFindImageUrisToDownload, (Iterable) setFindImageUrisToDownload2), (Iterable) findImageUrisToDownload(base.getBackground()));
    }

    public final void preDownloadOfferingImages(Offering offering) {
        Intrinsics.checkNotNullParameter(offering, "offering");
        if (!this.shouldPredownloadImages) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "OfferingImagePreDownloader won't pre-download images");
                return;
            }
            return;
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "OfferingImagePreDownloader: starting image download");
        }
        downloadV1Images(offering);
        downloadV2Images(offering);
    }

    public /* synthetic */ OfferingImagePreDownloader(boolean z2, CoilImageDownloader coilImageDownloader, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? UtilsKt.getCanUsePaywallUI() : z2, coilImageDownloader);
    }

    private final Set<Uri> findImageUrisToDownload(StackComponent stackComponent) {
        Set<Uri> setEmptySet;
        List<PaywallComponent> listFilter = PaywallComponentFilterExtensionKt.filter(stackComponent, new Function1<PaywallComponent, Boolean>() { // from class: com.revenuecat.purchases.utils.OfferingImagePreDownloader.findImageUrisToDownload.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PaywallComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf((it instanceof StackComponent) || (it instanceof IconComponent) || (it instanceof CarouselComponent) || (it instanceof TabsComponent) || (it instanceof ImageComponent) || (it instanceof CountdownComponent));
            }
        });
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (PaywallComponent paywallComponent : listFilter) {
            if (paywallComponent instanceof StackComponent) {
                StackComponent stackComponent2 = (StackComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload = findImageUrisToDownload(stackComponent2.getBackground());
                List overrides = stackComponent2.getOverrides();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                Iterator it = overrides.iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(linkedHashSet2, findImageUrisToDownload(((PartialStackComponent) ((ComponentOverride) it.next()).getProperties()).getBackground()));
                }
                setEmptySet = SetsKt.plus((Set) setFindImageUrisToDownload, (Iterable) linkedHashSet2);
            } else if (paywallComponent instanceof IconComponent) {
                IconComponent iconComponent = (IconComponent) paywallComponent;
                setEmptySet = SetsKt.setOf(Uri.parse(iconComponent.getBaseUrl()).buildUpon().path(iconComponent.getFormats().getWebp()).build());
            } else if (paywallComponent instanceof CarouselComponent) {
                CarouselComponent carouselComponent = (CarouselComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload2 = findImageUrisToDownload(carouselComponent.getBackground());
                List overrides2 = carouselComponent.getOverrides();
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                Iterator it2 = overrides2.iterator();
                while (it2.hasNext()) {
                    CollectionsKt.addAll(linkedHashSet3, findImageUrisToDownload(((PartialCarouselComponent) ((ComponentOverride) it2.next()).getProperties()).getBackground()));
                }
                setEmptySet = SetsKt.plus((Set) setFindImageUrisToDownload2, (Iterable) linkedHashSet3);
            } else if (paywallComponent instanceof TabsComponent) {
                TabsComponent tabsComponent = (TabsComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload3 = findImageUrisToDownload(tabsComponent.getBackground());
                List overrides3 = tabsComponent.getOverrides();
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                Iterator it3 = overrides3.iterator();
                while (it3.hasNext()) {
                    CollectionsKt.addAll(linkedHashSet4, findImageUrisToDownload(((PartialTabsComponent) ((ComponentOverride) it3.next()).getProperties()).getBackground()));
                }
                setEmptySet = SetsKt.plus((Set) setFindImageUrisToDownload3, (Iterable) linkedHashSet4);
            } else if (paywallComponent instanceof ImageComponent) {
                ImageComponent imageComponent = (ImageComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload4 = findImageUrisToDownload(imageComponent.getSource());
                List overrides4 = imageComponent.getOverrides();
                LinkedHashSet linkedHashSet5 = new LinkedHashSet();
                Iterator it4 = overrides4.iterator();
                while (it4.hasNext()) {
                    ThemeImageUrls source = ((PartialImageComponent) ((ComponentOverride) it4.next()).getProperties()).getSource();
                    Set<Uri> setFindImageUrisToDownload5 = source != null ? findImageUrisToDownload(source) : null;
                    if (setFindImageUrisToDownload5 == null) {
                        setFindImageUrisToDownload5 = SetsKt.emptySet();
                    }
                    CollectionsKt.addAll(linkedHashSet5, setFindImageUrisToDownload5);
                }
                setEmptySet = SetsKt.plus((Set) setFindImageUrisToDownload4, (Iterable) linkedHashSet5);
            } else if (paywallComponent instanceof VideoComponent) {
                ThemeImageUrls fallbackSource = ((VideoComponent) paywallComponent).getFallbackSource();
                setEmptySet = fallbackSource != null ? findImageUrisToDownload(fallbackSource) : null;
                if (setEmptySet == null) {
                    setEmptySet = SetsKt.emptySet();
                }
            } else if (paywallComponent instanceof CountdownComponent) {
                CountdownComponent countdownComponent = (CountdownComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload6 = findImageUrisToDownload(countdownComponent.getCountdownStack());
                StackComponent endStack = countdownComponent.getEndStack();
                Set<Uri> setFindImageUrisToDownload7 = endStack != null ? findImageUrisToDownload(endStack) : null;
                if (setFindImageUrisToDownload7 == null) {
                    setFindImageUrisToDownload7 = SetsKt.emptySet();
                }
                Set setPlus = SetsKt.plus((Set) setFindImageUrisToDownload6, (Iterable) setFindImageUrisToDownload7);
                StackComponent fallback = countdownComponent.getFallback();
                Set<Uri> setFindImageUrisToDownload8 = fallback != null ? findImageUrisToDownload(fallback) : null;
                if (setFindImageUrisToDownload8 == null) {
                    setFindImageUrisToDownload8 = SetsKt.emptySet();
                }
                setEmptySet = SetsKt.plus(setPlus, (Iterable) setFindImageUrisToDownload8);
            } else {
                setEmptySet = SetsKt.emptySet();
            }
            CollectionsKt.addAll(linkedHashSet, setEmptySet);
        }
        return linkedHashSet;
    }

    private final Set<Uri> findImageUrisToDownload(Background background) {
        URL webpLowRes;
        String string;
        URL webpLowRes2;
        String string2;
        Uri uri = null;
        if (background instanceof Background.Image) {
            Background.Image image = (Background.Image) background;
            Uri uri2 = Uri.parse(image.getValue().getLight().getWebpLowRes().toString());
            ImageUrls dark = image.getValue().getDark();
            if (dark != null && (webpLowRes2 = dark.getWebpLowRes()) != null && (string2 = webpLowRes2.toString()) != null) {
                uri = Uri.parse(string2);
            }
            return SetsKt.setOfNotNull((Object[]) new Uri[]{uri2, uri});
        }
        if (background instanceof Background.Video) {
            Background.Video video = (Background.Video) background;
            Uri uri3 = Uri.parse(video.getFallbackImage().getLight().getWebpLowRes().toString());
            ImageUrls dark2 = video.getFallbackImage().getDark();
            if (dark2 != null && (webpLowRes = dark2.getWebpLowRes()) != null && (string = webpLowRes.toString()) != null) {
                uri = Uri.parse(string);
            }
            return SetsKt.setOfNotNull((Object[]) new Uri[]{uri3, uri});
        }
        boolean z2 = true;
        if (!(background instanceof Background.Color ? true : background instanceof Background.Unknown) && background != null) {
            z2 = false;
        }
        if (z2) {
            return SetsKt.emptySet();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Set<Uri> findImageUrisToDownload(ThemeImageUrls themeImageUrls) {
        URL webpLowRes;
        String string;
        Uri uri = Uri.parse(themeImageUrls.getLight().getWebpLowRes().toString());
        ImageUrls dark = themeImageUrls.getDark();
        return SetsKt.setOfNotNull((Object[]) new Uri[]{uri, (dark == null || (webpLowRes = dark.getWebpLowRes()) == null || (string = webpLowRes.toString()) == null) ? null : Uri.parse(string)});
    }
}
