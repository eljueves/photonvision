# syntax=docker/dockerfile:1

FROM wpilib/debian-base:arm64-bookworm

# Copy project files (after Node is set up)
WORKDIR /app
COPY . .

# set java to 17
# RUN apt-get update && apt-get install -y openjdk-17-jdk
# ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-arm64
# ENV PATH=$JAVA_HOME/bin:$PATH

# Install nvm
RUN curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.3/install.sh | bash

# Install Node.js 22 via nvm
ENV NVM_DIR=/root/.nvm
RUN bash -c "source $NVM_DIR/nvm.sh && nvm install 22 && nvm alias default 22"

# Install pnpm globally via its official script
RUN wget -qO- https://get.pnpm.io/install.sh | ENV="$HOME/.bashrc" SHELL="$(which bash)" bash -

# Set environment variables for PNPM
ENV PNPM_HOME=/root/.local/share/pnpm
ENV PATH=$PNPM_HOME:$NVM_DIR/versions/node/v22.20.0/bin:$PATH

# Install JS dependencies and build frontend
RUN bash -c "source $NVM_DIR/nvm.sh && cd photon-client && pnpm install --force && cd .."


CMD ["./gradlew", "run"]


#build 
# docker build -t photon_trig .
#run with exposed camera browser ports
# docker run -it -p 5800:5800 photon_trig 


