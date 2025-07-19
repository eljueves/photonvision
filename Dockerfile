# syntax=docker/dockerfile:1

FROM wpilib/debian-base:arm64-bookworm

WORKDIR /app

COPY . .

RUN bash -c "\
  curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.3/install.sh | bash && \
  export NVM_DIR=\"/root/.nvm\" && \
  \\. \"$HOME/.nvm/nvm.sh\" && \
  nvm install 22.15.0 && \
  nvm use 22.15.0 && \
  cd photon-client && \
  npm install && \
  cd .. && \
  ./gradlew buildAndCopyUI \
"

CMD ["./gradlew", "run"]