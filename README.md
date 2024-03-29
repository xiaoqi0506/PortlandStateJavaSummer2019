# Getting Started with Advanced Programming with Java

This repository helps students in [Advanced Programming with
Java](http://web.cecs.pdx.edu/~whitlock/) get started with the
programming assignments.  Most noteably, it makes it so students do
not need install [Apache Maven](https://maven.apache.org/install.html)
on their local machines (or the PSU machines) in order to create and
build the programmming projects.  It makes liberal use of the [Maven
Wrapper](https://github.com/takari/maven-wrapper) script which
automatically downloads and installs the version of Maven needed for
the programming projects.

Prior to following these instructions, you may want to review the
"Getting Started with Java"
[slides](http://web.cecs.pdx.edu/~whitlock/pdf/Getting%20started%20with%20Java.pdf)
and
[screencast](https://www.youtube.com/watch?v=VZXEwcgigaw&list=SPyM7S4CZk9WPrtC8AclCNxOBA8buEJdib)
from the [course's website](http://web.cecs.pdx.edu/~whitlock/).

## How do I use this repository?

In order to use this repository, you must [intall
git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) on
your local machine.  Next you need to make a clone of the repository.

If you simply make a `git clone` of this GitHub repository on your
local machine, you can commit changes to your local repository, but
you can't "push" your changes to the repository hosted on GitHub.
This is because I own this GitHub repository and you do not have
permission to push changes from your local repository into my
repository.  Even if I did give you permission to push to my
repository, we don't want the source code that you wrote for your
projects to be available publically for everyone to see.

However, it would be very uesful to leverage git (and GitHub) to
easily move that code between multiple machines.  It would enable you
to develop your code on your local machine and test it on the PSU CS
Department's machines before you submit it.  This is possible to do
with GitHub, but it requires some extra steps.  GitHub provides some
[really good
documentation](https://help.github.com/en/articles/duplicating-a-repository)
on how to this and I'll summarize it here.

First, create a [GitHub "student
developer"](https://education.github.com/pack) account that gives you
free private repositories.  Then [create a private GitHub
repository](https://help.github.com/en/articles/creating-a-new-repository)
for your source code for this course.  (In this example, the
repository is named "PortlandStateJavaSummer2019".)  Note that you do
**not** want to "Initialize this repository with a README".  You want
to create a completely empty repository so that you can initially
populate it from my repository.

Now, here comes some of the magic.  Make a "bare" clone of my
repository.  This "bare" clone is disconnected from the remote
repository hosted on GitHub.  Note that the name of the directory is
`PortlandStateJavaGettingStarted.git`; it is not the same as a regular
clone of the repository.

```sh
$ git clone --bare https://github.com/DavidWhitlock/PortlandStateJavaGettingStarted.git
```

Then push the bare clone to your newly-created private repository.

```sh
$ cd PortlandStateJavaGettingStarted.git
$ git push --mirror https://github.com/YourGitHubUser/PortlandStateJavaSummer2019.git
```

If you view your repository on GitHub, you should see the changes
mirrored from my repository.

Now you can delete the bare clone and make a local clone your
repository to work with.

```sh
$ cd ..
$ rm -rf PortlandStateJavaGettingStarted.git
$ git clone https://github.com/YourGitHubUser/PortlandStateJavaSummer2019.git
```

### What do I need to do before I can use this repository?

The following command lines assume that you are running in the
directory created by cloning the repository.

```sh
$ cd PortlandStateJavaGettingStarted
```

You'll need to install the [latest version of the Java Development
Kit](https://jdk.java.net/) in order to run the Maven Wrapper and work
with the projects.

You'll also need to copy the `settings.xml` file to the `.m2`
directory in your home directory.  This configuration enables Maven to
find the artifacts used for the course.

```sh
$ mkdir ~/.m2
$ cp settings.xml ~/.m2/
```

### How do I create and run my own Java projects?

The primary purpose of this repository is to make it easy to create
the skeleton Java projects that are used to start your assignment.
Scripts such as `createProject0.sh` will run the appropriate Maven
commands to get you started.  Each of these scripts takes a single
argument which is your user id.  This one-word user id (mine is
`whitlock`) is used to uniquely identify your code and is included in
the name of the Java package for the project.

```sh
$ ./createProject0.sh your-user-id
```

This script will generate a new Maven project in a directory named
`student` for [Project
0](http://web.cecs.pdx.edu/~whitlock/pdf/Student.pdf), the example
"Student" project.  You can then build this project using the Maven
Wrapper included in the project.

```sh
$ cd student
$ chmod +x mvnw        # Make the wrapper script executable
$ ./mvnw verify
```

Note that the first time that you run Maven, it will download a whole
ton of libraries.  You'll see lots of text fly by.

If the build completes successful, you can use your favorite editor (I
highly recommend IntelliJ) to work the project.

### How can I commit my code to this repository?

After creating a Maven project, you can add the code it to your local
clone by adding the directory to git.

```sh
$ ./mvnw clean     # Remove files that shouldn't be commited to version control
$ cd ..    # to PortlandStateJavaSummer2019 directory
$ git add student
$ git commit -m "Added source files for student project"
```

By maintaining your project files in version control, you can easily
revert back to a known good version if something goes screwy.  You can
also use [git's branching
features](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging)
to easily revisit (and revise) your source code for Project 1 even
though you've started working on Project 2.

### How can I get changes that other people make into my clone?

You can expect that the scripts and information in this repository
will change and evolve over time.  You may want these changes in your
repository.  Here's what you need to do to incorporate changes made in
this "upstream" repository into your own repository.

First, configure your repository to have this repository to be a
"remote" named "upstream".

```sh
$ cd PortlandStateJavaSummer2019
$ git remote add upstream https://github.com/DavidWhitlock/PortlandStateJavaGettingStarted.git
```

Then, you can "pull" and "merge" changes from the upstream repository
in to your own local clone.

```sh
$ git pull upstream master
```

After you've resolved any conflicts caused by changes to your
repository and changes to the upstream repository.  You can push those
changes back to GitHub ("origin") with:

```sh
$ git push
```

## How do I use the "parent POM"?

This repository includes a "parent" [pom.xml](pom.xml) file.  You'll
need to edit the `pom.xml` file to include your user id and GitHub
user name.  As you create projects (such as Project 1), they will be
added as sub-modules to the parent POM.

Having a parent project (POM) for all of your projects is convenient
because it lets you build all of your code in one invocation of Maven.
While this is not strictly necessary, it does enable easy integration
with continuous integration tools such as Travis CI.  Travis CI is
free for public repositories, but they appear to have an [educational
program](https://education.travis-ci.com/) that is free to students
with a GitHub education account.

The parent project also allows you to create a multi-module [Maven
site](https://maven.apache.org/guides/mini/guide-site.html) for all of
your projects.

## How can I improve this repository?

This repository is kind of thrown together and it ought to evolve to
meet the needs of the students who take Advanced Programming with
Java.  

Feel free to [create issues](../../issues) for this repository if you find
something missing or confusing.

It's even better, though, when someone contribute their own changes
(add new scripts, augment documentation, fix type-os, etc.), to this
repository.  Please make a (public)
[fork](https://help.github.com/en/articles/fork-a-repo) of this
repository in GitHub, make your changes in a branch of that
repository, and [create a pull
request](https://help.github.com/en/articles/creating-a-pull-request-from-a-fork)
against this repository.  We can then have a discussion about your
changes via GitHub.
