#!/bin/bash
oc scale --replicas=1 dc/my-database -n sample-dev
oc scale --replicas=1 dc/sample-spring-boot -n sample-dev
oc scale --replicas=1 dc/my-database -n sample-test
oc scale --replicas=1 dc/sample-spring-boot-blue -n sample-test
oc scale --replicas=1 dc/sample-spring-boot-green -n sample-test
