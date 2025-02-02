{{/* vim: set filetype=mustache: */}}
{{- /*
service.labels.standard prints the standard service Helm labels.
The standard labels are frequently used in metadata.
*/ -}}

{{- define "service.image" -}}
{{- printf "%s:%s" .Values.image.repository (default (.Chart.Version) .Values.image.tag) -}}
{{- end -}}

{{- define "service.microservice.labels" -}}
abyssspecies.tech.io/version: {{ default (.Chart.Version) .Values.image.tag }}
abyssspecies.tech.io/service: {{ .Chart.Name | quote }}
abyssspecies.tech.io/metrics-port: {{ .Values.deployment.managementPort | quote }}
{{- end -}}

{{- define "service.labels.standard" -}}
abyssspecies.tech.io/release: {{ .Release.Name | quote }}
{{- end -}}

{{- define "service.match.labels" -}}
abyssspecies.tech.io/release: {{ .Release.Name | quote }}
{{- end -}}

{{- define "service.logging.deployment.label" -}}
abyssspecies.tech.io/logs-parser: {{ .Values.logs.parser | quote }}
{{- end -}}

{{- define "service.monitoring.pod.annotations" -}}
abyssspecies.tech.io/metrics-group: {{ .Values.metrics.group | quote }}
abyssspecies.tech.io/metrics-path: {{ .Values.metrics.path | quote }}
{{- end -}}

{{/*
Return the appropriate apiVersion for deployment.
*/}}
{{- define "app.deployment.apiVersion" -}}
{{- if semverCompare "<1.9-0" .Capabilities.KubeVersion.GitVersion -}}
{{- print "apps/v1beta2" -}}
{{- else -}}
{{- print "apps/v1" -}}
{{- end -}}
{{- end -}}

{{/*
Return the appropriate apiVersion for statefulset.
*/}}
{{- define "app.statefulset.apiVersion" -}}
{{- if semverCompare "<1.9-0" .Capabilities.KubeVersion.GitVersion -}}
{{- print "apps/v1beta2" -}}
{{- else -}}
{{- print "apps/v1" -}}
{{- end -}}
{{- end -}}

{{/*
Return the appropriate apiVersion for ingress.
*/}}
{{- define "app.ingress.apiVersion" -}}
{{- if semverCompare "<1.14-0" .Capabilities.KubeVersion.GitVersion -}}
{{- print "extensions/v1beta1" -}}
{{- else -}}
{{- print "networking.k8s.io/v1beta1" -}}
{{- end -}}
{{- end -}}