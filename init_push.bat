cd /d "%~dp0"
git init
git add *
git commit -a -m "version initiale"
git remote add gitHubOriginJpa2 https://didier-tp:pwd007!@github.com/didier-tp/m2idef_jpa.git
git push -u gitHubOriginJpa2 master
pause

REM open with text editor
REM opne with system editor