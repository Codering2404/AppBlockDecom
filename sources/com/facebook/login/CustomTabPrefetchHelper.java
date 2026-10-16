package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CustomTabPrefetchHelper extends CustomTabsServiceConnection {
    private static CustomTabsClient client;
    private static CustomTabsSession session;
    public static final Companion Companion = new Companion(null);
    private static final ReentrantLock lock = new ReentrantLock();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void prepareSession() {
            CustomTabsClient customTabsClient;
            CustomTabPrefetchHelper.lock.lock();
            if (CustomTabPrefetchHelper.session == null && (customTabsClient = CustomTabPrefetchHelper.client) != null) {
                CustomTabPrefetchHelper.session = customTabsClient.f(null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }

        @JvmStatic
        public final CustomTabsSession getPreparedSessionOnce() {
            CustomTabPrefetchHelper.lock.lock();
            CustomTabsSession customTabsSession = CustomTabPrefetchHelper.session;
            CustomTabPrefetchHelper.session = null;
            CustomTabPrefetchHelper.lock.unlock();
            return customTabsSession;
        }

        @JvmStatic
        public final void mayLaunchUrl(Uri url) {
            Intrinsics.checkNotNullParameter(url, "url");
            prepareSession();
            CustomTabPrefetchHelper.lock.lock();
            CustomTabsSession customTabsSession = CustomTabPrefetchHelper.session;
            if (customTabsSession != null) {
                customTabsSession.g(url, null, null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }

        private Companion() {
        }
    }

    @JvmStatic
    public static final CustomTabsSession getPreparedSessionOnce() {
        return Companion.getPreparedSessionOnce();
    }

    @JvmStatic
    public static final void mayLaunchUrl(Uri uri) {
        Companion.mayLaunchUrl(uri);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient newClient) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(newClient, "newClient");
        newClient.h(0L);
        client = newClient;
        Companion.prepareSession();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
    }
}
