package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DefaultUserAgentPublisher implements UserAgentPublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GlobalLibraryVersionRegistrar f89617b;

    DefaultUserAgentPublisher(Set set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.f89616a = d(set);
        this.f89617b = globalLibraryVersionRegistrar;
    }

    public static /* synthetic */ UserAgentPublisher b(ComponentContainer componentContainer) {
        return new DefaultUserAgentPublisher(componentContainer.f(LibraryVersion.class), GlobalLibraryVersionRegistrar.a());
    }

    public static Component c() {
        return Component.e(UserAgentPublisher.class).b(Dependency.o(LibraryVersion.class)).f(new ComponentFactory() { // from class: com.google.firebase.platforminfo.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return DefaultUserAgentPublisher.b(componentContainer);
            }
        }).d();
    }

    private static String d(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            LibraryVersion libraryVersion = (LibraryVersion) it.next();
            sb.append(libraryVersion.b());
            sb.append('/');
            sb.append(libraryVersion.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // com.google.firebase.platforminfo.UserAgentPublisher
    public String a() {
        if (this.f89617b.b().isEmpty()) {
            return this.f89616a;
        }
        return this.f89616a + ' ' + d(this.f89617b.b());
    }
}
