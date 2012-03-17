#!/bin/bash

mkdir db
mkdir segments
bin/nutch admin db -create
bin/nutch inject db -urlfile urls.txt
bin/nutch generate db segments
s1=`ls -d segments/2* | tail -1 `
echo $s1
bin/nutch fetch $s1
bin/nutch updatedb db $s1
bin/nutch analyze db 5

bin/nutch generate db segments -topN 100
s2=`ls -d segments/2* | tail -1`
echo $s2
bin/nutch fetch $s2
bin/nutch updatedb db $s2
bin/nutch analyze db 2

bin/nutch generate db segments -topN 100
s3=`ls -d segments/2* | tail -1`
echo $s3
bin/nutch fetch $s3
bin/nutch updatedb db $s3
bin/nutch analyze db 2

bin/nutch index $s1
bin/nutch index $s2
bin/nutch index $s3

bin/nutch dedup segments dedup.tmp
