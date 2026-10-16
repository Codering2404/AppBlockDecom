package com.superwall.sdk.network;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

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
public final class NetworkRequestData<Response> {
    private final Components components;
    private final Function3<Boolean, String, Continuation<? super Map<String, String>>, Object> factory;
    private boolean isForDebugging;
    private HttpMethod method;
    private String requestId;
    private final Duration timeout;
    private final URI url;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class HttpMethod {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HttpMethod[] $VALUES;
        public static final HttpMethod GET = new HttpMethod("GET", 0, "GET");
        public static final HttpMethod POST = new HttpMethod("POST", 1, "POST");
        private final String method;

        private static final /* synthetic */ HttpMethod[] $values() {
            return new HttpMethod[]{GET, POST};
        }

        static {
            HttpMethod[] httpMethodArr$values = $values();
            $VALUES = httpMethodArr$values;
            $ENTRIES = EnumEntriesKt.a(httpMethodArr$values);
        }

        private HttpMethod(String str, int i3, String str2) {
            this.method = str2;
        }

        public static EnumEntries<HttpMethod> getEntries() {
            return $ENTRIES;
        }

        public static HttpMethod valueOf(String str) {
            return (HttpMethod) Enum.valueOf(HttpMethod.class, str);
        }

        public static HttpMethod[] values() {
            return (HttpMethod[]) $VALUES.clone();
        }

        public final String getMethod() {
            return this.method;
        }
    }

    public /* synthetic */ NetworkRequestData(Components components, URI uri, HttpMethod httpMethod, String str, boolean z2, Function3 function3, Duration duration, DefaultConstructorMarker defaultConstructorMarker) {
        this(components, uri, httpMethod, str, z2, function3, duration);
    }

    public final NetworkRequestData<Response> copyWithUrl(URI newUrl) {
        Components componentsCopy;
        Intrinsics.checkNotNullParameter(newUrl, "newUrl");
        Components components = this.components;
        if (components == null) {
            componentsCopy = null;
        } else {
            String scheme = newUrl.getScheme();
            String host = newUrl.getHost();
            String path = newUrl.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            componentsCopy = components.copy(scheme, host, path, this.components.getQueryItems(), this.components.getBodyData());
        }
        return new NetworkRequestData<>(componentsCopy, this.url == null ? null : newUrl, this.method, this.requestId, this.isForDebugging, this.factory, this.timeout, null);
    }

    public final Components getComponents() {
        return this.components;
    }

    public final Function3<Boolean, String, Continuation<? super Map<String, String>>, Object> getFactory() {
        return this.factory;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    /* JADX INFO: renamed from: getTimeout-FghU774, reason: not valid java name */
    public final Duration m1313getTimeoutFghU774() {
        return this.timeout;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final boolean isForDebugging() {
        return this.isForDebugging;
    }

    public final void setForDebugging(boolean z2) {
        this.isForDebugging = z2;
    }

    public final void setMethod(HttpMethod httpMethod) {
        Intrinsics.checkNotNullParameter(httpMethod, "<set-?>");
        this.method = httpMethod;
    }

    public final void setRequestId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private NetworkRequestData(Components components, URI uri, HttpMethod method, String requestId, boolean z2, Function3<? super Boolean, ? super String, ? super Continuation<? super Map<String, String>>, ? extends Object> factory, Duration duration) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.components = components;
        this.url = uri;
        this.method = method;
        this.requestId = requestId;
        this.isForDebugging = z2;
        this.factory = factory;
        this.timeout = duration;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Components {
        private byte[] bodyData;
        private final String host;
        private final String path;
        private List<URLQueryItem> queryItems;
        private String scheme;

        public Components(String str, String str2, String path, List<URLQueryItem> list, byte[] bArr) {
            Intrinsics.checkNotNullParameter(path, "path");
            this.scheme = str;
            this.host = str2;
            this.path = path;
            this.queryItems = list;
            this.bodyData = bArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Components copy$default(Components components, String str, String str2, String str3, List list, byte[] bArr, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = components.scheme;
            }
            if ((i3 & 2) != 0) {
                str2 = components.host;
            }
            if ((i3 & 4) != 0) {
                str3 = components.path;
            }
            if ((i3 & 8) != 0) {
                list = components.queryItems;
            }
            if ((i3 & 16) != 0) {
                bArr = components.bodyData;
            }
            byte[] bArr2 = bArr;
            String str4 = str3;
            return components.copy(str, str2, str4, list, bArr2);
        }

        public final String component1() {
            return this.scheme;
        }

        public final String component2() {
            return this.host;
        }

        public final String component3() {
            return this.path;
        }

        public final List<URLQueryItem> component4() {
            return this.queryItems;
        }

        public final byte[] component5() {
            return this.bodyData;
        }

        public final Components copy(String str, String str2, String path, List<URLQueryItem> list, byte[] bArr) {
            Intrinsics.checkNotNullParameter(path, "path");
            return new Components(str, str2, path, list, bArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Components)) {
                return false;
            }
            Components components = (Components) obj;
            return Intrinsics.areEqual(this.scheme, components.scheme) && Intrinsics.areEqual(this.host, components.host) && Intrinsics.areEqual(this.path, components.path) && Intrinsics.areEqual(this.queryItems, components.queryItems) && Intrinsics.areEqual(this.bodyData, components.bodyData);
        }

        public final byte[] getBodyData() {
            return this.bodyData;
        }

        public final String getHost() {
            return this.host;
        }

        public final String getPath() {
            return this.path;
        }

        public final List<URLQueryItem> getQueryItems() {
            return this.queryItems;
        }

        public final String getScheme() {
            return this.scheme;
        }

        public int hashCode() {
            String str = this.scheme;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.host;
            int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.path.hashCode()) * 31;
            List<URLQueryItem> list = this.queryItems;
            int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            byte[] bArr = this.bodyData;
            return iHashCode3 + (bArr != null ? Arrays.hashCode(bArr) : 0);
        }

        public final void setBodyData(byte[] bArr) {
            this.bodyData = bArr;
        }

        public final void setQueryItems(List<URLQueryItem> list) {
            this.queryItems = list;
        }

        public final void setScheme(String str) {
            this.scheme = str;
        }

        public String toString() {
            return "Components(scheme=" + this.scheme + ", host=" + this.host + ", path=" + this.path + ", queryItems=" + this.queryItems + ", bodyData=" + Arrays.toString(this.bodyData) + ")";
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ Components(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.util.List r5, byte[] r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
            /*
                r1 = this;
                r8 = r7 & 1
                if (r8 == 0) goto L6
                java.lang.String r2 = "https"
            L6:
                r8 = r7 & 2
                r0 = 0
                if (r8 == 0) goto Lc
                r3 = r0
            Lc:
                r8 = r7 & 8
                if (r8 == 0) goto L11
                r5 = r0
            L11:
                r7 = r7 & 16
                if (r7 == 0) goto L1c
                r8 = r0
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r3 = r1
                goto L22
            L1c:
                r8 = r6
                r7 = r5
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
            L22:
                r3.<init>(r4, r5, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.NetworkRequestData.Components.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.List, byte[], int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public /* synthetic */ NetworkRequestData(Components components, URI uri, HttpMethod httpMethod, String str, boolean z2, Function3 function3, Duration duration, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : components, (i3 & 2) != 0 ? null : uri, (i3 & 4) != 0 ? HttpMethod.GET : httpMethod, (i3 & 8) != 0 ? UUID.randomUUID().toString() : str, (i3 & 16) != 0 ? false : z2, function3, duration, null);
    }
}
