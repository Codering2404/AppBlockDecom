package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TabControlButtonComponent;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class PaywallComponentFilterExtensionKt {
    public static final List<PaywallComponent> filter(PaywallComponent paywallComponent, Function1<? super PaywallComponent, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(paywallComponent, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(paywallComponent);
        while (!arrayDeque.isEmpty()) {
            PaywallComponent paywallComponent2 = (PaywallComponent) arrayDeque.removeFirst();
            if (((Boolean) predicate.invoke(paywallComponent2)).booleanValue()) {
                arrayList.add(paywallComponent2);
            }
            if (paywallComponent2 instanceof StackComponent) {
                arrayDeque.addAll(((StackComponent) paywallComponent2).getComponents());
            } else if (paywallComponent2 instanceof PurchaseButtonComponent) {
                arrayDeque.add(((PurchaseButtonComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof ButtonComponent) {
                arrayDeque.add(((ButtonComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof PackageComponent) {
                arrayDeque.add(((PackageComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof HeaderComponent) {
                arrayDeque.add(((HeaderComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof StickyFooterComponent) {
                arrayDeque.add(((StickyFooterComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof CarouselComponent) {
                arrayDeque.addAll(((CarouselComponent) paywallComponent2).getPages());
            } else if (paywallComponent2 instanceof TabControlButtonComponent) {
                arrayDeque.add(((TabControlButtonComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof TabsComponent) {
                TabsComponent tabsComponent = (TabsComponent) paywallComponent2;
                TabsComponent.TabControl control = tabsComponent.getControl();
                if (control instanceof TabsComponent.TabControl.Buttons) {
                    arrayDeque.add(((TabsComponent.TabControl.Buttons) control).getStack());
                } else if (control instanceof TabsComponent.TabControl.Toggle) {
                    arrayDeque.add(((TabsComponent.TabControl.Toggle) control).getStack());
                }
                List tabs = tabsComponent.getTabs();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(tabs, 10));
                Iterator it = tabs.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((TabsComponent.Tab) it.next()).getStack());
                }
                arrayDeque.addAll(arrayList2);
            } else if (paywallComponent2 instanceof TimelineComponent) {
                List<TimelineComponent.Item> items = ((TimelineComponent) paywallComponent2).getItems();
                ArrayList arrayList3 = new ArrayList();
                for (TimelineComponent.Item item : items) {
                    CollectionsKt.addAll(arrayList3, CollectionsKt.listOfNotNull((Object[]) new PaywallComponent[]{item.getTitle(), item.getDescription(), item.getIcon()}));
                }
                arrayDeque.addAll(arrayList3);
            } else if (paywallComponent2 instanceof CountdownComponent) {
                CountdownComponent countdownComponent = (CountdownComponent) paywallComponent2;
                arrayDeque.add(countdownComponent.getCountdownStack());
                StackComponent endStack = countdownComponent.getEndStack();
                if (endStack != null) {
                    arrayDeque.add(endStack);
                }
                StackComponent fallback = countdownComponent.getFallback();
                if (fallback != null) {
                    arrayDeque.add(fallback);
                }
            }
        }
        return arrayList;
    }
}
