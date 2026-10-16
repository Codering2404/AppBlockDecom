package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DependencyCycleException extends DependencyException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f88129a;

    public DependencyCycleException(List list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f88129a = list;
    }
}
