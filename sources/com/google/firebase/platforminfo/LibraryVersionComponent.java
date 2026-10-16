package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class LibraryVersionComponent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface VersionExtractor<T> {
        String a(Object obj);
    }

    public static Component b(String str, String str2) {
        return Component.l(LibraryVersion.a(str, str2), LibraryVersion.class);
    }

    public static Component c(final String str, final VersionExtractor versionExtractor) {
        return Component.m(LibraryVersion.class).b(Dependency.l(Context.class)).f(new ComponentFactory() { // from class: com.google.firebase.platforminfo.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return LibraryVersion.a(str, versionExtractor.a((Context) componentContainer.a(Context.class)));
            }
        }).d();
    }
}
