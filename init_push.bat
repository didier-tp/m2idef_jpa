cd /d "%~dp0"
git init
git add *
git commit -a -m "version initiale"
git remote add gitHubOriginTpJpa https://didier-tp:password@github.com/didier-tp/m2idef_tpJpa.git
git push -u gitHubOriginTpJpa master
pause

REM open with text editor
REM opne with system editor