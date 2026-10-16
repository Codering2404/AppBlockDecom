package com.revenuecat.purchases.ui.revenuecatui.data;

import androidx.compose.material3.ColorScheme;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    public static final int $stable = 8;
    private final ColorScheme colorScheme;
    private final boolean isDarkMode;
    private final PaywallOptions options;
    private final boolean preview;
    private final ResourceProvider resourceProvider;
    private final Function1<CustomerInfo, Boolean> shouldDisplayBlock;

    public /* synthetic */ PaywallViewModelFactory(ResourceProvider resourceProvider, PaywallOptions paywallOptions, ColorScheme colorScheme, boolean z2, Function1 function1, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(resourceProvider, paywallOptions, colorScheme, z2, function1, (i3 & 32) != 0 ? false : z3);
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return new PaywallViewModelImpl(this.resourceProvider, null, this.options, this.colorScheme, this.isDarkMode, this.shouldDisplayBlock, this.preview, null, 130, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallViewModelFactory(ResourceProvider resourceProvider, PaywallOptions options, ColorScheme colorScheme, boolean z2, Function1<? super CustomerInfo, Boolean> function1, boolean z3) {
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.resourceProvider = resourceProvider;
        this.options = options;
        this.colorScheme = colorScheme;
        this.isDarkMode = z2;
        this.shouldDisplayBlock = function1;
        this.preview = z3;
    }
}
