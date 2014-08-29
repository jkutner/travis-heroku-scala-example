APP_NAME="sheltered-citadel-3631"

# rm -rf target/heroku/
# mkdir -p "target/heroku/app/dependency"
# cp target/dependency/* target/heroku/app/dependency
# cp target/*.war target/heroku/app/
#
# JDK_URL="http://heroku-jdk.s3.amazonaws.com/openjdk1.7.0_45.tar.gz"
#
#cd target/heroku
# mkdir -p "app/.jdk"
# curl --silent --location ${JDK_URL} | tar pxz -C app/.jdk
#
#tar pczfv slug.tgz ./app

# create the Auth token
HK_TOKEN="OjFlN2FiNDc1LWZkZmEtNDQ1MS05MmUyLWFlMjgyOTNkYTNmZAo=" #`(echo -n ":" ; echo "${1:-HEROKU_API_KEY}") | base64`

echo -n "---> Creating the Slug..."
HK_SLUG1=$(curl -s -X POST \
-H 'Content-Type: application/json' \
-H 'Accept: application/vnd.heroku+json; version=3' \
-H "Authorization: ${HK_TOKEN}" \
-d '{"process_types":{"web":"stage/bin/scala-getting-started"}}' \
https://api.heroku.com/apps/${APP_NAME}/slugs)
echo " done"

HK_SLUG=$(echo "$HK_SLUG1" | tr -d '\n')
HK_BLOB_URL=$(expr "$HK_SLUG" : ".*\"url\":\"\(https://.*\)\" *}, *\"buildpack_provided_description")
HK_SLUG_ID=$(expr "$HK_SLUG" : ".*\"id\":\"\(.*\)\", *\"process_types")

echo -n "---> Uploading the Slug..."
curl -X PUT \
-H "Content-Type:" \
--data-binary @target/heroku/slug.tgz \
"$HK_BLOB_URL"
echo " done"

echo "---> Creating the Release..."
curl -X POST \
-H "Accept: application/vnd.heroku+json; version=3" \
-H "Content-Type: application/json" \
-H "Authorization: ${HK_TOKEN}" \
-d "{\"slug\":\"${HK_SLUG_ID}\"}" \
https://api.heroku.com/apps/${APP_NAME}/releases

heroku releases --app ${APP_NAME}
